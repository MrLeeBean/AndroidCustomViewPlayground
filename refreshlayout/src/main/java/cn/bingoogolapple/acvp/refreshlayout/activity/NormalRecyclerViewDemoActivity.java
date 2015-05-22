package cn.bingoogolapple.acvp.refreshlayout.activity;

import java.util.List;

import cn.bingoogolapple.acvp.refreshlayout.adapter.RecyclerViewAdapter;
import cn.bingoogolapple.acvp.refreshlayout.mode.RefreshModel;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/5/22 10:06
 * 描述:
 */
public class NormalRecyclerViewDemoActivity extends BaseRecyclerViewDemoActivity {
    private RecyclerViewAdapter mAdapter;

    @Override
    protected void initRefreshLayout() {
        initCustomHeaderView();
    }

    @Override
    protected void initRecyclerView() {
        mAdapter = new RecyclerViewAdapter(this);
        mAdapter.setDatas(mDatas);
        mAdapter.setOnRVItemClickListener(this);
        mAdapter.setOnRVItemLongClickListener(this);
        mDataRv.setAdapter(mAdapter);
    }

    @Override
    protected void onEndRefreshing(List<RefreshModel> datas) {
        mDatas.addAll(0, datas);
        mAdapter.setDatas(mDatas);
    }

}