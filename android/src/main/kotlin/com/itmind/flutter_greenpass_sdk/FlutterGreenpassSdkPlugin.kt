package com.itmind.flutter_greenpass_sdk

import androidx.annotation.NonNull

import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.embedding.engine.plugins.activity.ActivityAware
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.PluginRegistry.Registrar
import it.ministerodellasalute.verificaC19sdk.worker.LoadKeysWorker;
import it.ministerodellasalute.verificaC19sdk.VerificaMinVersionException
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import android.util.Log
import androidx.activity.viewModels
import it.ministerodellasalute.verificaC19sdk.model.CertificateSimple
import it.ministerodellasalute.verificaC19sdk.model.CertificateStatus
import it.ministerodellasalute.verificaC19sdk.model.SimplePersonModel
import it.ministerodellasalute.verificaC19sdk.model.VerificationViewModel
import it.ministerodellasalute.verificaC19sdk.util.FORMATTED_BIRTHDAY_DATE
import it.ministerodellasalute.verificaC19sdk.util.TimeUtility.parseFromTo
import it.ministerodellasalute.verificaC19sdk.util.YEAR_MONTH_DAY
import android.app.Activity



/** FlutterGreenpassSdkPlugin */
class FlutterGreenpassSdkPlugin: FlutterPlugin, MethodCallHandler, ActivityAware  {
  var act: android.app.Activity? = null
  private lateinit var result: Result
  override fun onAttachedToActivity(binding: ActivityPluginBinding) {
    act = binding.activity
//    model by viewModels<VerificationViewModel>() can't call

  }
  override fun onDetachedFromActivityForConfigChanges() {
    act = null;
  }
  override fun onReattachedToActivityForConfigChanges(binding: ActivityPluginBinding) {
    act = binding.activity

  }
  override fun onDetachedFromActivity() {
    act = null;
  }

  /// The MethodChannel that will the communication between Flutter and native Android
  ///
  /// This local reference serves to register the plugin with the Flutter Engine and unregister it
  /// when the Flutter Engine is detached from the Activity
  private lateinit var channel : MethodChannel

  override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
    channel = MethodChannel(flutterPluginBinding.binaryMessenger, "flutter_greenpass_sdk")
    channel.setMethodCallHandler(this)


  }

  override fun onMethodCall(@NonNull call: MethodCall, @NonNull result: Result) {
    if (call.method == "getPlatformVersion") {
      result.success("Android ${android.os.Build.VERSION.RELEASE}")
    }else if (call.method == "validateQrCode") {
      val code: String? = call.argument("code");

      decodeQrCode(code.toString())
      result.success(code) //per ora restituisco un "code" che passo
    } else {
      result.notImplemented()
    }
  }

  private fun decodeQrCode(qrCodeText: String): String {

//      val viewModel by viewModels<VerificationViewModel>() can't call  for error
//            viewModel.init(qrCodeText, true);
    // TODO: qua sarabbe da capire come a questo punto "istanziare" il viewModel della sdk!

            return "OK";
        }

  override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
    channel.setMethodCallHandler(null)
  }
}
