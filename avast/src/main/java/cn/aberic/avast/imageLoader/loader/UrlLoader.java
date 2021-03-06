package cn.aberic.avast.imageLoader.loader;

import android.graphics.Bitmap;

import cn.aberic.avast.core.AVast;
import cn.aberic.avast.http.base.Request;
import cn.aberic.avast.cache.request.BitmapCacheRequest;

/**
 * 作者：Aberic on 16/2/17 00:05
 * 邮箱：abericyang@gmail.com
 */
public class UrlLoader extends AbsLoader {

    @Override
    protected void onLoadImage(final BitmapCacheRequest request) {
        AVast.obtain().http.imageLoader(request.imageUri, new Request.RequestListener<Bitmap>() {
            @Override
            public void onComplete(int stCode, Bitmap response) {
                cacheBitmap(request, response);// 缓存图片
                deliveryToUIThread(request,response);
            }
        });
    }
}
