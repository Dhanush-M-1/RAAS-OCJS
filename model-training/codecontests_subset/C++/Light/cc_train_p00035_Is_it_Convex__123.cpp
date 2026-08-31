#include<iostream>
#include<vector>
#include<algorithm>
#include<cstdio>
#include<cstdlib>
#include<string>
#include<sstream>
#include<cmath>
#include<numeric>
#include<map>
#include<stack>
#include<queue>
#include<list>
using namespace std;
int inf = 1000000000;

bool check(double x1, double y1, double x2, double y2){
  return x1 * y2 - y1 * x2 > 0;
}

int main(void) {

  vector<double> x(4);
  vector<double> y(4);
  while( scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf", &x[0], &y[0], &x[1], &y[1], &x[2], &y[2], &x[3], &y[3]) != EOF ){
    bool f = true;
    for(int i=0; i<4; i++){
      int j = i + 1;
      bool a = check(x[i%4]-x[(i+1)%4], y[i%4]-y[(i+1)%4], x[(i+1)%4]-x[(i+2)%4], y[(i+1)%4]-y[(i+2)%4]);
      bool b = check(x[j%4]-x[(j+1)%4], y[j%4]-y[(j+1)%4], x[(j+1)%4]-x[(j+2)%4], y[(j+1)%4]-y[(j+2)%4]);
      if( a != b ){
        f = false;
        break;
      }
    }
    cout << ( f ? "YES":"NO") << endl;
  }

  return 0;
}

// EOF