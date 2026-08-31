#include <bits/stdc++.h>
using namespace std;
const long long N = 2e5 + 5;
long long n, m, s[N], a[N], C[N], vis[N];
long long lowbit(long long x) { return (x & (-x)); }
long long sum(long long x) {
  long long res = 0;
  while (x > 0) {
    res += C[x];
    x -= lowbit(x);
  }
  return res;
}
void add(long long x, long long d) {
  d = d * x;
  while (x < N) {
    C[x] += d;
    x += lowbit(x);
  }
}
int main() {
  cin >> n;
  for (long long i = 1; i <= n; i++) {
    cin >> s[i], add(i, 1);
  }
  for (long long i = n; i >= 1; i--) {
    long long l = 1, r = n, ans = 0;
    while (l <= r) {
      long long mid = (r + l) >> 1, su = (sum(mid - 1));
      if (su == s[i]) {
        if (vis[mid]) {
          l = mid + 1;
          continue;
        }
        ans = mid;
        add(mid, -1);
        break;
      }
      if (su < s[i]) {
        l = mid + 1;
      } else
        r = mid - 1;
    }
    a[i] = ans;
    vis[ans] = 1;
  }
  for (long long i = 1; i <= n; i++) {
    cout << a[i] << " ";
  }
  cout << endl;
}
