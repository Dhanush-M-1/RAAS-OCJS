#include <iostream>
#include <cmath>

using namespace std;

int main(void){

  double x[4];
  double y[4];
  char ten;

  while( cin >> x[0] >> ten >> y[0] ){

    cin >> ten >> x[1] >> ten >> y[1] >> ten >> x[2] >> ten >> y[2] >> ten >> x[3] >> ten >> y[3]; 

    double Area = 0;
    int I;
    for( int i = 0 ; i < 4 ; i++ ){//座標から多角形の面積を求める公式
      if( i == 3 ){
	I = 0;
      }
      else{
	I = i + 1;
      }
      Area += ( x[i] * y[I] ) - ( x[I] * y[i] );
    }

    Area = abs(Area) / 2;

    double area[4];
    area[0] = x[0]*y[1] - x[1]*y[0] + x[1]*y[2] - x[2]*y[1] + x[2]*y[0] - x[0]*y[2];
    area[1] = x[1]*y[2] - x[2]*y[1] + x[2]*y[3] - x[3]*y[2] + x[3]*y[1] - x[1]*y[3];
    area[2] = x[2]*y[3] - x[3]*y[2] + x[3]*y[0] - x[0]*y[3] + x[0]*y[2] - x[2]*y[0];
    area[3] = x[3]*y[0] - x[0]*y[3] + x[0]*y[1] - x[1]*y[0] + x[1]*y[3] - x[3]*y[1];

    for( int i = 0 ; i < 4 ; i++ ){
      area[i] = abs(area[i]) / 2; 
    }
   
   
    double AREA = area[0] + area[1] + area[2] + area[3];
    //cout << area[0] << "---" << area[1] << "---" << area[2] << "---" << area[3]<< endl;
    //cout << Area << endl;
    //cout << AREA << endl;
    if( AREA == 2*Area ) cout << "YES" << endl;
    else cout << "NO" << endl;

  }
  return 0;
}