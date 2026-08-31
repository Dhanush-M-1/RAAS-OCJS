#include <iostream>
#include <cassert>
#define REP(i,l,n) for(int i=l;i<n;++i)
#define rep(i,n) REP(i,0,n)
int ans;
int Q,n;
using namespace std;
int main() {
  cin >> Q;
  rep(i,Q){
    cin >> n;
    ans = 0;
    while(n > 9){
      ans++;
      int max = 0,div = 1;
      rep(j,5){
        div *= 10;
        int post = (n/div)*(n%div);
        if(post>max) max = post;
      }
      n = max;
    }
    cout << ans << endl;
  }
  return 0;
}