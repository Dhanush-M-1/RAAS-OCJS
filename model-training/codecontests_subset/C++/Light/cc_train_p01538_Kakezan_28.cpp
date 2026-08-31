#include <bits/stdc++.h>

#define REP(i, n) for(int i = 0; i < (int) (n); i++)
#define ALL(v) (v).begin(), (v).end()
#define INF 1e9

using namespace std;

int main(){
  int q;
  cin >> q;
  REP(i, q){
    int n;
    cin >> n;
    int res = 0;
    while(n >= 10){
      int divisor = 10;
      int maxim = 0;
      REP(j, 6){
        if(divisor >= n) break;
        maxim = max(maxim, (n / divisor) * (n % divisor));
        divisor *= 10;
      }
      n = maxim;
      res++;
      // cout << n << endl;
      if(res > 100) { res = -1; break; }
    }
    cout << res << endl;
  }
}