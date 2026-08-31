#include <iostream>
#include <string>
#include <algorithm>
#include <cmath>
#include <vector>
#include <set>
#include <cstdlib>

using namespace std;
typedef long long LL;
static const double EPS = 1e-9;

#define FOR(i,k,n) for (int i=(k); i<(int)(n); ++i)
#define REP(i,n) FOR(i,0,n) 
int judge(double t1, double t2){
  int j=1;
  if(abs(t2-t1)>M_PI) j*=-1;
  if(t2-t1<0) j*=-1;
  return j;
}

int main(void){  
  double x[4],y[4],t[4];
  while(cin>>x[0]){
    int s = 0;
    cin.ignore();
    cin >> y[0];
    for(int i=1;i<4;i++){
      cin.ignore();
      cin >> x[i];
      cin.ignore();
      cin >> y[i];
    }
    REP(i,4)
      t[i] = atan2(y[(i+1)%4]-y[i], x[(i+1)%4]-x[i]);
    REP(i,4)
      s+=judge(t[i],t[(i+1)%4]);
    if(abs(s) == 4)
      cout << "YES" << endl;
    else
      cout << "NO" << endl;
  }
  return 0;
}