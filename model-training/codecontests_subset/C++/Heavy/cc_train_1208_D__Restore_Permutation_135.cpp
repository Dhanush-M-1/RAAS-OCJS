#include <bits/stdc++.h>
using namespace std;
const int MAXN = 2e5 + 5;
int n, ans[MAXN], mark[MAXN];
long long s[MAXN], tree[MAXN];
void add(int x, int val) {
  for (; x <= n; x += x & -x) tree[x] += val;
}
long long ask(int x) {
  long long res = 0;
  for (; x; x &= x - 1) res += tree[x];
  return res;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  cin >> n;
  for (int i = 0; i < n; ++i) cin >> s[i];
  for (int i = n - 1; ~i; --i) {
    int l = 1, r = n, ans = -1;
    while (l <= r) {
      int mid = (l + r) >> 1;
      if (1LL * mid * (mid - 1) / 2 - ask(mid - 1) <= s[i]) {
        ans = mid;
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
    if (ans < 0) exit(-1);
    ::ans[i] = ans;
    add(ans, ans);
  }
  for (int i = 0; i < n; ++i) cout << ans[i] << ' ';
  return 0;
}
