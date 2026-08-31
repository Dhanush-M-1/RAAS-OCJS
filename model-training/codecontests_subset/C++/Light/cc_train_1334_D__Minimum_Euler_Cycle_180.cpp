#include <bits/stdc++.h>
using namespace std;
const long long N = 2e5 + 10;
long long n;
long long pre[N];
long long cal(long long x) {
  if (x == n * (n - 1) + 1) return 1;
  long long p = lower_bound(pre + 1, pre + n + 1, x) - pre;
  long long b = x - pre[p - 1];
  if (b & 1)
    return p;
  else
    return p + b / 2;
}
signed main() {
  long long t;
  cin >> t;
  while (t--) {
    long long l, r;
    cin >> n >> l >> r;
    for (long long i = 1; i <= n; i++) pre[i] = pre[i - 1] + 2 * (n - i);
    for (long long i = l; i <= r; i++) cout << cal(i) << " ";
    puts("");
  }
  return 0;
}
