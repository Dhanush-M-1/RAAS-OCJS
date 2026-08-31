#include <set>
#include <map>
#include <list>
#include <queue>
#include <stack>
#include <cmath>
#include <ctype.h>
#include <ctime>
#include <cstdio>
#include <vector>
#include <string>
#include <bitset>
#include <cctype>
#include <cstdlib>
#include <cstring>
#include <utility>
#include <numeric>
#include <complex>
#include <sstream>
#include <fstream>
#include <iomanip>
#include <cassert>
#include <iostream>
#include <iterator>
#include <algorithm>

using namespace std;

#define REP(i, x, n) for(int i = x; i < n; i++)
#define rep(i, n) REP(i, 0, n)
#define lengthof(x) (sizeof(x) / sizeof(*(x)))
#define FILL(ptr, value) FILL_((ptr), sizeof(ptr)/sizeof(value), (value))
template <typename T>
void FILL_(void * ptr, size_t size, T value){
  std::fill((T*)ptr, (T*)ptr+size, value);
}
//4方向ベクトル→↑←↓
int dx[] ={1,0,-1,0};
int dy[] ={0,-1,0,1};

 


int main()
{
  double xa,xb,xc,xd,ya,yb,yc,yd;
  while(scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf",&xa,&ya,&xb,&yb,&xc,&yc,&xd,&yd)!=EOF){
    double td =(xa-xc)*(yd-ya)+(ya-yc)*(xa-xd);
    double tb =(xa-xc)*(yb-ya)+(ya-yc)*(xa-xb);
    double ta =(xb-xd)*(ya-yb)+(yb-yd)*(xb-xa);
    double tc =(xb-xd)*(yc-yb)+(yb-yd)*(xb-xc);

    if(td*tb >0.0||ta*tc>0.0)
      cout <<"NO"<<endl;
    else
      cout <<"YES"<<endl;
  }
  return 0;
}