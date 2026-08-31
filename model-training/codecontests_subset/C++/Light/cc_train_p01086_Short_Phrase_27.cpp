#include <bits/stdc++.h>
using namespace std;
#define REP(i,b,e) for(int i=(b);i<(e);++i)
#define rep(i,e) for(int i=0;i<(e);++i)

int main() {
  int n;
  while(cin >> n){
    if(n==0) return 0;
    vector<string> v(n);
    rep(i, n) cin >> v[i];

    bool good=false;
    rep(i, n){
      int state=0, cur=0;
      if(good) break;
      REP(j, i, n){
        cur += v[j].size();
        if(cur==5 && (state==0 || state==2)){
          cur = 0; state += 1;
        }
        else if(cur==7 && (state==1 || state==3 || state==4)){
          cur = 0; state += 1;
        }
        else if(cur>7) break;
        if(state==5){
          cout << i+1 << endl;
          good = true;
          break;
        }
      }
    }
  }
  return 0;
}
