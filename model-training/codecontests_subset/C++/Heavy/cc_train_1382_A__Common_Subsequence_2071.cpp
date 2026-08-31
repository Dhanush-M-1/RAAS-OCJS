#include <bits/stdc++.h>
using namespace std;
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
const long long maxn = 3e3;
const long long mod = 1e9 + 7;
const long double PI = acos((long double)-1);
long long pw(long long a, long long b, long long md = mod) {
  long long res = 1;
  while (b) {
    if (b & 1) {
      res = (a * res) % md;
    }
    a = (a * a) % md;
    b >>= 1;
  }
  return (res);
}
int q;
int n, m;
int a[maxn], b[maxn];
int cnt1[maxn], cnt2[maxn];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> q;
  while (q--) {
    cin >> n >> m;
    for (int i = 0; i < n; i++) cin >> a[i];
    for (int i = 0; i < m; i++) cin >> b[i];
    for (int i = 0; i < n; i++) cnt1[a[i]] = 1;
    for (int j = 0; j < m; j++) cnt2[b[j]] = 1;
    int ans = -1;
    for (int i = 0; i < 3e3; i++)
      if (cnt1[i] and cnt2[i]) ans = i;
    memset(cnt1, 0, sizeof cnt1);
    ;
    memset(cnt2, 0, sizeof cnt2);
    ;
    if (ans == -1)
      cout << "NO";
    else
      cout << "YES" << '\n' << 1 << ' ' << ans;
    cout << '\n';
  }
  return (0);
}
