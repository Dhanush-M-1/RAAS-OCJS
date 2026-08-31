#include <bits/stdc++.h>
using namespace std;
long long n, i, j, k, m, x;
void solve() {
  cin >> n;
  string a;
  cin >> a;
  for (i = 0; i < a.size(); i++) {
    if (a[i] == '8') {
      m++;
    }
  }
  if (n < 11) {
    cout << "0";
  } else {
    int count = 0;
    cout << min(n / 11, m);
  }
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  ;
  int T = 1;
  while (T--) {
    solve();
    cout << endl;
  }
  return 0;
}
