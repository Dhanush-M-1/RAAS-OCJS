#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>
#include <complex>
#include <cstring>
#include <cstdlib>
#include <string>
#include <cmath>
#include <queue>
using namespace std;

#define REP(i,n) for(int i=0;i<(int)n;++i)
#define FOR(i,c) for(__typeof((c).begin())i=(c).begin();i!=(c).end();++i)
#define ALL(c) (c).begin(), (c).end()
#define INF 1<<30

int main() {
  int n;
  while(cin >> n,n) {
    int v[n];
    REP(i,n)
      cin >> v[i];
    int res = 0;
    REP(i,n) {
      REP(j,n-i-1) {
        if (v[j] > v[j+1]) {
          //  printf("%d,%d, %d,%d\n",i,j,v[j],v[j+1]);
          swap(v[j],v[j+1]);
          res++;
        }
      }
    }
    cout << res << endl;
  }
}