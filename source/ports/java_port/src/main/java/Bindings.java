package metacall;

import java.util.*;
import java.io.*;

import com.sun.jna.*;
import com.sun.jna.Library;
import com.sun.jna.PointerByReference;

//import util.*;

// default visibility of classes is package-private | Scala equivalent of protected[pkg]
class Bindings extends Library
{
  /*
  * Trying to define SIZET, FunctionPointer in util.java
  i* n parallel to what is done in Scala port
  * util util = new util();
  * Temporarily all SIZET params are defined as long instead of unsigned int
  */

  // TODO
  /*
  * val instance = Native.load("metacall", classOf[Bindings])
  * val runningInMetacall = System.getProperty("metacall.polyglot.name") == "core"
  */

  int metacall_initialize();

  void metacall_log_null();

  int metacall_load_from_file(String tag, String paths[], long size, PointerByReference handle);

  Pointer metacall_handle_export(Pointer handle);

  Pointer metacallv_s(String name, Pointer args[], long size);
  Pointer metacallfv_s(Pointer func, Pointer args[], long size);

  // TODO
  // metacall_await_s,  metacall_await_future


  Pointer metacallhv_s(Pointer handle, String name, Pointer args[], long size);

  // TODO
  // metacall_register

  Pointer metacall_function(String name);
  long metacall_function_size(Pointer func);
  int metacall_function_async(Pointer func);
  int metacall_destroy();


  //metacall_value.h
  Pointer metacall_value_create_int(int i);
  Pointer metacall_value_create_long(long l);
  Pointer metacall_value_create_short(short s);
  Pointer metacall_value_create_string(String str, long length);
  Pointer metacall_value_create_char(char c);
  Pointer metacall_value_create_double(double d);
  Pointer metacall_value_create_float(float f);
  Pointer metacall_value_create_boolean(boolean b);
  Pointer metacall_value_create_function(Pointer f);
  Pointer metacall_value_create_array(Pointer values[], long size);
  Pointer metacall_value_create_map(Pointer tuples[], long size);
  Pointer metacall_value_create_null();

  int metacall_value_to_int(Pointer v);
  long metacall_value_to_long(Pointer v);
  short metacall_value_to_short(Pointer v);
  float metacall_value_to_float(Pointer v);
  double metacall_value_to_double(Pointer v);
  boolean metacall_value_to_bool(Pointer v);
  char metacall_value_to_char(Pointer v);
  String metacall_value_to_string(Pointer v);
  Pointer[] metacall_value_to_array(Pointer v);
  //TODO
  //metacall_value_to_null
  //  def metacall_value_to_null(v: Pointer): Null

  Pointer metacall_value_to_function(Pointer v);
  Pointer[] metacall_value_to_map(Pointer v);
  Pointer metacall_value_to_future(Pointer v);

  Pointer metacall_value_from_int(Pointer v, int i);
  Pointer metacall_value_from_string(Pointer v, String str, long length);

  long metacall_value_size(Pointer v);
  Pointer metacall_value_count(Pointer v);
  void metacal_value_destroy(Pointer v);
  int metacall_value_id(Pointer v);

}
