package ipca.combustivel.cmprojetooo.fragmentos

import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.google.zxing.qrcode.QRCodeWriter

import ipca.combustivel.cmprojetooo.R


class BlankFragment2 : Fragment() {



    private lateinit var qrcode : ImageView
    private lateinit var texted : EditText
    private lateinit var buttoncode : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttoncode = view.findViewById<Button>(R.id.button2)
        texted = view.findViewById<EditText>(R.id.inserttext)
        qrcode = view.findViewById<ImageView>(R.id.qrcode)

        buttoncode.setOnClickListener {
            val qrcodetext = texted.text.toString().trim()

            val writeqr = QRCodeWriter()
            if(qrcodetext.isEmpty()){
                Toast.makeText(activity, "Error please enter promotion code", Toast.LENGTH_SHORT).show()
            }else{
            try {
                val bitMatrix = writeqr.encode(qrcodetext, BarcodeFormat.QR_CODE, 512, 512)
                val width = bitMatrix.width
                val height = bitMatrix.height
                val bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)
                for (x in 0 until width) {
                    for (y in 0 until height) {
                        bmp.setPixel(x,y, if(bitMatrix[x,y]) Color.BLACK else Color.WHITE)

                    }
                }
                qrcode.setImageBitmap(bmp)


            }catch(e: WriterException){
                e.printStackTrace()
            }
        }
        }

    }

}