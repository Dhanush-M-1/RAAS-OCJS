#include <bits/stdc++.h>
const long long MOD = 1e9 + 7;
using namespace std;
void solve() {
  int n, k;
  cin >> n >> k;
  int Ans = -1;
  for (int i = 0; i < n; i++) {
    int x;
    cin >> x;
    if (k % x == 0 && x > Ans) Ans = x;
  }
  cout << k / Ans;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int t;
  t = 1;
  while (t--) {
    solve();
    cout << "\n";
    ;
  }
  return 0;
}
