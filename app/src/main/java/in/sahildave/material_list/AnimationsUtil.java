package in.sahildave.material_list;

import android.view.View;

/**
 * Created by sahil on 10/4/15.
 */
public class AnimationsUtil {

    public static void scaleUpAnimation(View view){
        view.animate().scaleX(1.1f).scaleY(1.1f).start();
    }

    public static void scaleDownAnimation(View view) {
        view.animate().scaleX(0.9f).scaleY(0.9f).start();
    }

    public static void scaleBackAnimation(View view) {
        view.animate().scaleX(1.0f).scaleY(1.0f).start();
    }

}
