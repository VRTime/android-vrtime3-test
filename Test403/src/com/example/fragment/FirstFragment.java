package com.example.fragment;

import com.example.test403.R;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FirstFragment extends Fragment
{
	private Button mBtn_SecondFragment;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.firstfragment, container, false);

		initViews(view);

		return view;
	}

	private void initViews(View rootView)
	{
		mBtn_SecondFragment = (Button) rootView.findViewById(R.id.btn_SecondFragment);

		mBtn_SecondFragment.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
//				fragmentTransaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
				fragmentTransaction.addToBackStack(null);

				Fragment fragment = getFragmentManager().findFragmentById(R.layout.secondfragment);
				if (fragment == null)
				{
					fragment = new SceondFragment();
					fragmentTransaction.replace(R.id.container, fragment);
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
