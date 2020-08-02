package com.example.weatherforecast.addweather

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.ProgressBar
import com.example.weatherforecast.addweather.AddWeatherContract.Presenter


class AddWeatherDialogFragment : DialogFragment(),
    AddWeatherContract.View {
    private var mPresenter: Presenter? = null

    @BindView(R.id.et_city)
    var mEditTextCity: EditText? = null

    @BindView(R.id.loading_add_city)
    var mLoadingIndicator: ProgressBar? = null
    fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = Builder(getActivity())
        // Get the layout inflater
        val inflater: LayoutInflater = getActivity().getLayoutInflater()

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        val view: View = inflater.inflate(R.layout.dialog_add_city, null)
        ButterKnife.bind(this, view)
        builder.setView(view) // Add action buttons
            .setPositiveButton(R.string.add, null)
            .setNegativeButton(R.string.cancel, null)
        return builder.create()
    }

    fun onStart() {
        super.onStart()
        val d: AlertDialog? = getDialog() as AlertDialog?
        if (d != null) {
            val positiveButton: Button = d.getButton(Dialog.BUTTON_POSITIVE)
            positiveButton.setOnClickListener(object : OnClickListener() {
                fun onClick(v: View?) {
                    mPresenter!!.addCity(mEditTextCity!!.text.toString())
                }
            })
        }
    }

    fun setPresenter(presenter: Presenter?) {
        mPresenter = presenter
    }

    val isActive: Boolean
        get() = isAdded()

    override fun closeView() {
        (getTargetFragment() as WeatherFragment).addCityDialogDismiss()
        this@AddWeatherDialogFragment.getDialog().dismiss()
    }

    override fun displayErrorMessage(stringRessource: Int) {
        mEditTextCity!!.error = getString(stringRessource)
    }

    override fun displayLoadingIndicator(isVisible: Boolean?) {
        mLoadingIndicator.setVisibility(if (isVisible!!) View.VISIBLE else View.GONE)
        mEditTextCity.setVisibility(if (isVisible!!) View.GONE else View.VISIBLE)
    }

    companion object {
        fun newInstance(): AddWeatherDialogFragment {
            return AddWeatherDialogFragment()
        }
    }
}