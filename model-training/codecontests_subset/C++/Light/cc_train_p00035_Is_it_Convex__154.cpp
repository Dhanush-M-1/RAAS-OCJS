#include <iostream>
using namespace std;

double check(double ax,double ay, double bx, double by){
  return ax*by - ay*bx;
}

int main(){
  double x[4],y[4];
  char c;

  while( cin>>x[0]>>c>>y[0] && c ){
    for( int i=1;i<4;i++ )
      cin >> c >>  x[i] >> c >> y[i];

    bool f=true;
    for( int i=0;i<4;i++ ){
      int j = (i+1)%4, k=(i+2)%4, l=(i+3)%4;

      double ax=x[i]-x[j], ay=y[i]-y[j];
      if( check(ax,ay,x[j]-x[k],y[j]-y[k]) *
	  check(ax,ay,x[j]-x[l],y[j]-y[l]) > 0 ){
      }else{
	f=false;
	break;
      }
    }
    if( f )
      cout << "YES" << endl;
    else
      cout << "NO" << endl;
  }
  return 0;
}