#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 7;
int n, sum[maxn], r[maxn];
void add(int i) {
  while (i <= n) {
    sum[i]++;
    i += i & (-i);
  }
}
int getsum(int i) {
  int ans = 0;
  while (i) {
    ans += sum[i];
    i -= i & (-i);
  }
  return ans;
}
int bs(int s, int e, int t) {
  int mid = (s + e) / 2;
  if (s >= e) return mid;
  if (getsum(mid) >= t)
    return bs(s, mid, t);
  else
    return bs(mid + 1, e, t);
}
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    int x;
    cin >> x;
    r[x] = i;
  }
  long long ans = 0;
  for (int i = 1; i <= n; i++) {
    ans += i - 1 - getsum(r[i]);
    int s, e;
    s = bs(1, n, i / 2);
    if (i % 2 == 1)
      e = bs(1, n, i / 2 + 1);
    else
      e = s;
    if (!(s <= r[i] && r[i] <= e)) {
      if (r[i] < s)
        ans += s - r[i] - 1 - getsum(s - 1);
      else
        ans += r[i] - e + getsum(e) - i;
    } else
      ans -= i / 2;
    cout << ans << " ";
    add(r[i]);
  }
  cout << '\n';
  return 0;
}
