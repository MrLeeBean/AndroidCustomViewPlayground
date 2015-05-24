package cn.bingoogolapple.acvp.refreshlayout.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;

import cn.bingoogolapple.acvp.refreshlayout.R;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/5/21 13:16
 * 描述:
 */
public class BGAStickinessRefreshViewHolder extends BGARefreshViewHolder {
    private BGAStickinessRefreshView mStickinessRefreshView;
    private Drawable mRotateDrawable;
    private int mStickinessColor = -1;

    public BGAStickinessRefreshViewHolder(Context context) {
        super(context);
    }

    @Override
    public View getLoadMoreFooterView() {
        return null;
    }

    @Override
    public View getRefreshHeaderView() {
        if (mRefreshHeaderView == null) {
            mRefreshHeaderView = View.inflate(mContext, R.layout.view_refresh_header_stickiness, null);
            mStickinessRefreshView = (BGAStickinessRefreshView) mRefreshHeaderView.findViewById(R.id.stickinessRefreshView);
            mStickinessRefreshView.setStickinessRefreshViewHolder(this);
            if (mRotateDrawable != null) {
                mStickinessRefreshView.setRotateDrawable(mRotateDrawable);
            }
            if (mStickinessColor != -1) {
                mStickinessRefreshView.setStickinessColor(mStickinessColor);
            }
        }
        return mRefreshHeaderView;
    }

    public void setRotateDrawable(Drawable rotateDrawable) {
        mRotateDrawable = rotateDrawable;
    }

    public void setStickinessColor(int stickinessColor) {
        mStickinessColor = stickinessColor;
    }

    @Override
    public void handleScale(float scale, int moveYDistance) {
        mStickinessRefreshView.setMoveYDistance(moveYDistance);
    }

    @Override
    public void changeToIdle() {
        mStickinessRefreshView.smoothToIdle();
    }

    @Override
    public void changeToPullDown() {
    }

    @Override
    public void changeToReleaseRefresh() {
    }

    @Override
    public void changeToRefreshing() {
        mStickinessRefreshView.startRefreshing();
    }

    @Override
    public void onEndLoadingMore() {
    }

    @Override
    public void onEndRefreshing() {
        mStickinessRefreshView.stopRefresh();
    }

    @Override
    public void changeToLoadingMore() {
    }

    @Override
    public boolean canChangeToRefreshingStatus() {
        return mStickinessRefreshView.canChangeToRefreshing();
    }

}