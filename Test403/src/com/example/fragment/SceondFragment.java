package com.example.fragment;

import com.example.test403.R;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class SceondFragment extends Fragment
{
	private Button mBtn_MainFragment;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View rootView = inflater.inflate(R.layout.secondfragment, container, false);

		initViews(rootView);
		if (rootView != null)
			return rootView;

		return super.onCreateView(inflater, container, savedInstanceState);
	}

	private void initViews(View rootView)
	{
		mBtn_MainFragment = (Button) rootView.findViewById(R.id.btn_mainFragment);

		mBtn_MainFragment.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
				fragmentTransaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
				fragmentTransaction.addToBackStack(null);

				Fragment fragment = getFragmentManager().findFragmentById(R.layout.firstfragment);
				if (fragment == null)
				{
					fragment = new PlaceholderFragment();
					fragmentTransaction.replace(R.id.container, fragment, fragment.getClass().getName());
				}
				else
				{
					if (fragment.isHidden())
						fragmentTransaction.show(fragment);
					else
						fragmentTransaction.hide(fragment);
				}
				fragmentTransaction.commit();
			}
		});
	}
}
