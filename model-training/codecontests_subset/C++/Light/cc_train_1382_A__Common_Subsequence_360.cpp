#include <bits/stdc++.h>
using namespace std;
void solve() {
  long long n, m;
  cin >> n >> m;
  vector<long long> v(1001, 0);
  for (int i = 0; i < n; i++) {
    long long input;
    cin >> input;
    v[input]++;
  }
  long long ans = 0;
  for (int i = 0; i < m; i++) {
    long long input;
    cin >> input;
    if (v[input] != 0) ans = input;
  }
  if (ans == 0)
    cout << "NO"
         << "\n";
  else {
    cout << "YES"
         << "\n"
         << 1 << " " << ans << "\n";
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  ;
  int tt = 1;
  cin >> tt;
  while (tt--) {
    solve();
  }
}
