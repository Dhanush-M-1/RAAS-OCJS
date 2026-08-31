#include <bits/stdc++.h>
using namespace std;
void NITRO() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
}
const long long N = 1e+17;
const int MOD = 998244353;
const long long INF = 1e+18;
void SOLVE() {
  int n, k, ans = 111;
  cin >> n >> k;
  while (n--) {
    int num;
    cin >> num;
    if (k % num == 0) ans = min(k / num, ans);
  }
  cout << ans;
}
int main() {
  int t = 1;
  while (t--) {
    SOLVE();
  }
  return 0;
}
