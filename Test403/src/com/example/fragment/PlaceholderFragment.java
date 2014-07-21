package com.example.fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.test403.R;

public class PlaceholderFragment extends Fragment
{

	private Button mBtn_FirstFragment;

	public PlaceholderFragment()
	{
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View rootView = inflater.inflate(R.layout.fragment_main, container, false);
		initViews(rootView);
		return rootView;
	}

	private void initViews(View rootView)
	{
		mBtn_FirstFragment = (Button) rootView.findViewById(R.id.btn_firstFragment);

		mBtn_FirstFragment.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
//				getFragmentManager().beginTransaction().add(R.id.container, new PlaceholderFragment()).commit();
				FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
//				fragmentTransaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
				fragmentTransaction.setCustomAnimations(R.anim.fade_out, R.anim.fade_out);
				fragmentTransaction.addToBackStack(null);
				
				Fragment fragment = getFragmentManager().findFragmentById(R.layout.firstfragment);
				if(fragment == null)
					fragmentTransaction.replace(R.id.container, new FirstFragment());
				else
				{
					if(fragment.isHidden())
						fragmentTransaction.show(fragment);
					else
						fragmentTransaction.hide(fragment);
				}
				fragmentTransaction.commit();
			}
		});
	}
}