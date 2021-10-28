
import 'dart:async';

import 'package:flutter/services.dart';

class FlutterGreenpassSdk {
  static const MethodChannel _channel =
      const MethodChannel('flutter_greenpass_sdk');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }
  static Future<String> validateQrCode(String code) async {
    final String valid = await _channel.invokeMethod('validateQrCode', {code: code});
    return valid;
  }

}
