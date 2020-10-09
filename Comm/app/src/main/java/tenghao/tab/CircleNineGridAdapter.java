package tenghao.tab;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.cjlu.R;
import com.giftedcat.picture.lib.photoview.GlideImageLoader;
import com.giftedcat.picture.lib.photoview.style.index.NumberIndexIndicator;
import com.giftedcat.picture.lib.photoview.style.progress.ProgressBarIndicator;
import com.giftedcat.picture.lib.photoview.transfer.TransferConfig;
import com.giftedcat.picture.lib.photoview.transfer.Transferee;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

import content.write.OnAddPicturesListener;
import me.kareluo.ui.PopupMenuView;
import tenghao.tenghao.MainActivity;

public class CircleNineGridAdapter extends CommonAdapter<String> {

    PopupMenuView menuView;
    private Context context;
    OnAddPicturesListener listener;
    private int deletePosition;
    protected Transferee transferee;
    protected TransferConfig config;
    List<String> selectPath;
    public CircleNineGridAdapter(Context context, List<String> selectPath, RecyclerView rvImages) {
        super(context, R.layout.circle_item_image, selectPath);
        this.context = context;
        initTransfer(rvImages);
        this.selectPath = selectPath;
        selectPath.add("");
//        LogselectPath(selectPath);
    }

    private void LogselectPath(List<String> t) {
        for(String a:t){
            Log.e(MainActivity.TAG,a);
        }
    }

    public void setMaxSize(int maxNum) {
        config.setMax(maxNum);
    }

    public void setOnAddPicturesListener(OnAddPicturesListener listener) {
        this.listener = listener;
    }

    private void initTransfer(RecyclerView rvImages) {
        transferee = Transferee.getDefault(context);
        config = TransferConfig.build()
                .setSourceImageList(getDatas())
                .setProgressIndicator(new ProgressBarIndicator())
                .setIndexIndicator(new NumberIndexIndicator())
                .setImageLoader(GlideImageLoader.with(context.getApplicationContext()))
                .setJustLoadHitImage(true)
                .bindRecyclerView(rvImages, R.id.iv_show);
    }


    @Override
    protected void convert(ViewHolder viewHolder, String item, final int position) {

        ImageView ivShow = viewHolder.getView(R.id.iv_show);
        if (item.equals("")) {
            ivShow.setVisibility(View.GONE);
        } else {
            ivShow.setVisibility(View.VISIBLE);
            Glide.with(mContext).load(item).into(ivShow);
            ivShow.setOnClickListener(new CircleNineGridAdapter.PicturesClickListener(position));
        }
    }


    private class PicturesClickListener implements View.OnClickListener {

        int position;
        public PicturesClickListener(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.iv_show) {
                config.setNowThumbnailIndex(position);
                config.setSourceImageList(getDatas());
                transferee.apply(config).show();
            }
        }
    }
}
