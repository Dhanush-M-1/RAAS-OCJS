#include <bits/stdc++.h>
using namespace std;
const int MN = 200010;
int n;
long long ft[MN];
void update(int pos, long long by) {
  while (pos < n) ft[pos] += by, pos |= pos + 1;
}
long long query(int pos) {
  long long ans = 0;
  while (pos >= 0) ans += ft[pos], pos = (pos & (pos + 1)) - 1;
  return ans;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cin >> n;
  vector<long long> a(n);
  for (int i = 0; i < n; i++) cin >> a[i];
  for (int i = 0; i < n; i++) update(i, i);
  vector<int> ans(n);
  for (int i = n - 1; i >= 0; i--) {
    int lo = 0, hi = n;
    while (hi - lo > 1) {
      int mi = (hi + lo) / 2;
      if (query(mi) <= a[i])
        lo = mi;
      else
        hi = mi;
    }
    update(lo + 1, -lo - 1);
    ans[i] = lo;
  }
  for (int i = 0; i < n; i++) cout << ans[i] + 1 << " ";
  cout << '\n';
  return 0;
}
