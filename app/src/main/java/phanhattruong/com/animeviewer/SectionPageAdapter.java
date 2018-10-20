package phanhattruong.com.animeviewer;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by admin on 19/10/2018.
 */

public class SectionPageAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> FmList = new ArrayList<Fragment>();
    private  ArrayList<String> FmTileList = new ArrayList<String>();

    public SectionPageAdapter(FragmentManager fm) {
        super(fm);
    }

    public  void AddFragment(Fragment fm, String tile){
        this.FmList.add(fm);
        this.FmTileList.add(tile);
    }

    @Override
    public CharSequence getPageTitle(int position) {
       return  this.FmTileList.get(position);
    }

    @Override
    public Fragment getItem(int position) {
       return this.FmList.get(position);
    }

    @Override
    public int getCount() {
        return FmTileList.size();
    }
}
