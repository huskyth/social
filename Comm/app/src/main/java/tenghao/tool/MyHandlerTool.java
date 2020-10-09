package tenghao.tool;

import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;

import java.lang.ref.WeakReference;

public class MyHandlerTool {

    public static class MyCallback implements Handler.Callback {

        @Override
        public boolean handleMessage(@NonNull Message msg) {
            return false;
        }
    }
    public static class MyHandler extends Handler {
        WeakReference<MyCallback> mListenerWeakReference;

        public MyHandler(MyCallback listener) {
            mListenerWeakReference = new WeakReference<>(listener);

        }

        @Override
        public void handleMessage(Message msg) {
            if (mListenerWeakReference!=null && mListenerWeakReference.get()!=null){
                mListenerWeakReference.get().handleMessage(msg);
            }
        }
    }
}
