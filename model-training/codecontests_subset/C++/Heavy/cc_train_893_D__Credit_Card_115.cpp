#include <bits/stdc++.h>
using namespace std;
const int N = 100500;
int main() {
  srand(time(NULL));
  ios_base::sync_with_stdio(0);
  int n;
  long long d;
  cin >> n >> d;
  long long cur = 0;
  int ans = 0;
  long long mx = 0;
  int last = 0;
  for (int i = 1; i <= n; i++) {
    long long x;
    cin >> x;
    if (x == 0) {
      if (cur < 0) {
        if (last == 0)
          ans++, last = 1, mx = 0, cur = 0;
        else {
          cur += (d - mx);
          last = 0;
          if (cur < 0)
            ans++, last = 1, cur = 0, mx = 0;
          else {
            mx += -(cur - (d - mx));
            last = 1;
            cur = 0;
          }
        }
      }
    } else {
      cur += x;
      mx = max(cur, mx);
      if (cur > d) cout << "-1", exit(0);
    }
  }
  cout << ans;
  return 0;
}
