#include <bits/stdc++.h>
using namespace std;
const int N = 100005, Mod = 998244353;
string arr[N], s;
long long n, pos, mx, dig, ans, frq[15], fp[25];
void solve(int idx) {
  s = arr[idx];
  for (int i = 0; i < s.size(); ++i) {
    pos = s.size() - i - 1, mx = 2 * pos + 1, dig = s[i] - '0';
    for (int j = 0; j < 12; ++j) {
      ans += (dig * fp[min(mx, pos + j)] * frq[j]) % Mod;
      ans %= Mod;
      ans += (dig * fp[min(mx - 1, pos + j)] * frq[j]) % Mod;
      ans %= Mod;
    }
  }
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n, fp[0] = 1;
  for (int i = 0; i < n; ++i) cin >> arr[i], ++frq[arr[i].size()];
  for (int i = 1; i < 25; ++i) fp[i] = (fp[i - 1] * 10) % Mod;
  for (int i = 0; i < n; ++i) solve(i);
  cout << ans;
  return 0;
}
