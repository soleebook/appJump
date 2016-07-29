package cn.abcdsxg.app.appJump.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.List;

import butterknife.BindView;
import cn.abcdsxg.app.appJump.Base.BaseFragment;
import cn.abcdsxg.app.appJump.Data.Adapter.GridViewAdapter;
import cn.abcdsxg.app.appJump.Data.greenDao.AppInfo;
import cn.abcdsxg.app.appJump.Data.greenDao.DBManager;
import cn.abcdsxg.app.appJump.R;

/**
 * Author : 时小光
 * Email  : abcdsxg@gmail.com
 * Blog   : http://www.abcdsxg.cn
 * Date   : 2016/7/26 11:12
 */
public class GridViewFragment extends BaseFragment {

    public static final String PAGE_NUM = "PAGE_NUM";
    @BindView(R.id.gridViewApp)
    GridView gridView;
    GridViewAdapter mAdapter;
    List<AppInfo> appInfos;
    private int mPageNum;
    private DBManager dbManager;
    @Override
    public View setView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gridview, container, false);
    }

    public static Fragment newInstant(int page) {
        Bundle args = new Bundle();
        args.putInt(PAGE_NUM, page);
        GridViewFragment pageFragment = new GridViewFragment();
        pageFragment.setArguments(args);
        return pageFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbManager=DBManager.getInstance();
        mPageNum = getArguments().getInt(PAGE_NUM);
        appInfos= dbManager.queryAppInfoList();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mAdapter=new GridViewAdapter(mApplication,appInfos);

    }

}
