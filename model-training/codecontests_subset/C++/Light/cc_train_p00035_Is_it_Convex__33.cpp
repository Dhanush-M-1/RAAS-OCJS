#include <iostream>
#include <cmath>
using namespace std;
struct P{
  double x,y;
  P(){}
  P(double x,double y):x(x),y(y){}
};
bool isIntersecter(P a,P b,P p,P q ){
  return ((a.x - b.x)*(p.y - a.y) - (a.y - b.y)*(p.x - a.x))*((a.x - b.x)*(q.y - a.y) - (a.y - b.y)*(q.x - a.x)) > 0;
}
int main(){
  P a[4];
  char c;
  while(cin >> a[0].x){
    cin >> c >> a[0].y; 
    for(int i = 1 ; i < 4 ; i++ ) {
      cin >> c >> a[i].x >> c >> a[i].y;  
    }
    if(isIntersecter(a[0],a[2],a[1],a[3]) ||
       isIntersecter(a[1],a[3],a[0],a[2])){
      cout << "NO" << endl;
    } else cout << "YES" << endl;

  }
}