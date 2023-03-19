package ru.omgtu.lab03

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import butterknife.BindView
import butterknife.OnClick

/**
 * A simple [Fragment] subclass.
 * Use the [ImageViewerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ImageViewerFragment : BaseFragment() {
    @BindView(R.id.image)
    lateinit var imageView: ImageView

    private var currentImage = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image_viewer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageView.setImageResource(IMAGES[currentImage])
    }

    @OnClick(R.id.next)
    fun onNextClicked() {
        currentImage++
        if (currentImage >= IMAGES.size) {
            currentImage = 0
        }

        imageView.setImageResource(IMAGES[currentImage])
    }

    companion object {
        const val TAG = "IMAGEVIEWERFRAGMENT"

        val IMAGES = arrayOf(
            R.drawable.borzoi1,
            R.drawable.borzoi2,
            R.drawable.borzoi3,
            R.drawable.borzoi4,
        )

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment ImageViewerFragment.
         */
        @JvmStatic
        fun newInstance() = ImageViewerFragment()
    }
}