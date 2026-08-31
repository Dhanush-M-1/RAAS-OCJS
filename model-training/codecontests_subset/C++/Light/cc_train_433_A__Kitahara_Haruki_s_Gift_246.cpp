#include <bits/stdc++.h>
using namespace std;
const long long N = 2e5;
void solve() {
  long long n;
  cin >> n;
  long long o, t;
  o = t = 0;
  long long w;
  for (long long i = 0; i < n; i++) {
    cin >> w;
    if (w == 100)
      o++;
    else {
      t++;
    }
  }
  if (o % 2 || (o == 0 && t % 2)) {
    cout << "NO";
    return;
  }
  cout << "YES";
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long t = 1;
  while (t--) solve();
  return 0;
}
