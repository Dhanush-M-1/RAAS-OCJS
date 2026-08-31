#include <bits/stdc++.h>
using namespace std;
int n;
long long s[200066];
long long c[200066];
long long ans[200066];
long long lowbit(long long x) { return x & (-x); }
long long q(long long x) {
  long long ans = 0;
  while (x > 0) {
    ans += c[x];
    x -= lowbit(x);
  }
  return ans;
}
void update(long long x, long long v) {
  while (x <= n) {
    c[x] += v;
    x += lowbit(x);
  }
}
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> s[i];
    update(i, i);
  }
  for (int i = n; i >= 1; i--) {
    long long l = 1;
    long long r = n;
    long long mid;
    while (l < r) {
      mid = (l + r + 1) / 2;
      if (q(mid - 1) <= s[i]) {
        l = mid;
      } else
        r = mid - 1;
    }
    ans[i] = l;
    update(l, -l);
  }
  for (int i = 1; i <= n; i++) {
    if (i != n)
      cout << ans[i] << " ";
    else
      cout << ans[i] << endl;
  }
}
