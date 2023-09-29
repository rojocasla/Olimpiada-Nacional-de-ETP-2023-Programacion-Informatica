#include <LiquidCrystal.h>
#define BOTON 8
  
int RS = 12;
int EN = 11;
int D4 = 7;
int D5 = 6;
int D6 = 5;
int D7 = 4;

LiquidCrystal lcd(RS, EN, D4, D5, D6, D7);


void setup() {
  lcd.begin(16,2);
  pinMode(BOTON, INPUT);


}

void loop() {
 
  lcd.setCursor(0,0);

  if(digitalRead(BOTON) == 1){
  lcd.print("holaMundo");
  }
  else{
  lcd.clear();
   }

}
