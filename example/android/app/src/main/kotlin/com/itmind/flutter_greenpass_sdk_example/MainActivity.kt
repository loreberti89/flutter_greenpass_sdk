package com.itmind.flutter_greenpass_sdk_example

import androidx.lifecycle.LifecycleOwner
import android.util.Log
import androidx.activity.viewModels
import androidx.annotation.NonNull
import androidx.lifecycle.observe
import dagger.hilt.android.AndroidEntryPoint
import io.flutter.embedding.android.FlutterFragmentActivity
import io.flutter.embedding.engine.FlutterEngine
import it.ministerodellasalute.verificaC19sdk.model.CertificateSimple
import it.ministerodellasalute.verificaC19sdk.model.CertificateStatus
import it.ministerodellasalute.verificaC19sdk.model.SimplePersonModel
import it.ministerodellasalute.verificaC19sdk.model.VerificationViewModel
import it.ministerodellasalute.verificaC19sdk.util.FORMATTED_BIRTHDAY_DATE
import it.ministerodellasalute.verificaC19sdk.util.TimeUtility.parseFromTo
import it.ministerodellasalute.verificaC19sdk.util.YEAR_MONTH_DAY
import io.flutter.plugin.common.MethodChannel

class MainActivity: FlutterFragmentActivity() {

    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {

        super.configureFlutterEngine(flutterEngine)

    }
    /*private val CHANNEL = "loreberti.dev/decodeqrcode"
    private val viewModel by viewModels<VerificationViewModel>()

        override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
                super.configureFlutterEngine(flutterEngine)
        
                viewModel.certificate.observe(this) { certificate ->
                        certificate?.let {
                                // TODO: qui occorre elaborare la risposta!
                                Log.i("MainActivity", "Risultato certificato: "  )
                //                certificateModel = it
                //                setPersonData(it.person, it.dateOfBirth)
                //                setupCertStatusView(it)
                //                setupTimeStamp(it)
                //                if (viewModel.getTotemMode() && (certificate.certificateStatus == CertificateStatus.VALID
                //                            || certificate.certificateStatus == CertificateStatus.PARTIALLY_VALID)) {
                //                    Handler().postDelayed({
                //                        activity?.onBackPressed()
                //                    }, 5000)
                //                }
                            }
                    }
        
                MethodChannel(
                        flutterEngine.dartExecutor.binaryMessenger,
                        CHANNEL
                            ).setMethodCallHandler { call, result ->
                        if (call.method == "decodeQrCode") {
                                val qrCodeData = call.argument<String>("qrCodeText")?.let {
                                        decodeQrCode(it)
                                    }
                
                                if (qrCodeData != null) {
                                        result.success(qrCodeData)
                                    } else {
                                        result.error("UNAVAILABLE", "Data not available.", null)
                                    }
                            } else {
                                result.notImplemented()
                            }
                    }
            }
    
        private fun decodeQrCode(qrCodeText: String): String {
                viewModel.init(qrCodeText, true);
        
                // TODO: questo non è il valore da ritornare al chiamante!
                return "OK";
            }*/
    
}
