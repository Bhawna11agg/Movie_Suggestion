import 'package:flutter/cupertino.dart';
import 'package:flutter/gestures.dart';
import 'package:flutter/material.dart';
import 'package:flutter/rendering.dart';
import 'package:flutter/widgets.dart';
import 'package:google_fonts/google_fonts.dart';
class  Description extends StatefulWidget {
  @override
  _DescriptionState createState() => _DescriptionState();
}
class _DescriptionState extends State<Description> {
  @override
  Widget build(BuildContext context) {
    return SafeArea(
      child: Scaffold(
        body: ListView(
          children: [
            Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Container(
                  decoration: new BoxDecoration(
                      color: Colors.white,
                      borderRadius: new BorderRadius.all(Radius.circular(20.0)),
                      boxShadow: [
                        BoxShadow(color: Colors.black12,offset: Offset(2.0, 2.0)),  //shadow to container
                      ]
                  ),
                  padding: EdgeInsets.all(5.0),
                  margin: EdgeInsets.fromLTRB(20.0, 20.0, 20.0, 20.0),
                  child: Column(
                    children: [
                      Card(
                        color: Color(0xfff2f2f2),
                        margin: EdgeInsets.all(5.0),
                        child: Column(
                          //crossAxisAlignment: CrossAxisAlignment.start,
                          children: [
                            Align(
                              alignment: Alignment.centerLeft,
                              child: Text(
                                  " Description",
                                  style: GoogleFonts.comfortaa(
                                    textStyle:   TextStyle(
                                      color: Color(0xff794A97),
                                      fontSize: 30.0,
                                      fontWeight: FontWeight.bold,
                                    ),
                                  )
                              ),
                            ),
                            SizedBox(
              