#include <bits/stdc++.h>
using namespace std;
const int N = 200001;
long long pre[N] = {};
void add(long long p, long long x) {
  for (long long i = p; i <= N; i += (i & -i)) pre[i] += x;
}
long long query(long long p) {
  long long ans = 0;
  for (long long i = p; i > 0; i -= i & (-i)) ans += pre[i];
  return ans;
}
int main() {
  long long n;
  cin >> n;
  long long x[n], ans[n];
  for (long long i = 1; i <= n; i++) add(i, i);
  for (long long i = 0; i < n; i++) cin >> x[i];
  for (long long i = n - 1; i >= 0; i--) {
    long long l = 0, r = n, mid;
    while (l < r) {
      mid = l + r >> 1;
      if (query(mid) <= x[i])
        l = mid + 1;
      else
        r = mid;
    }
    ans[i] = l;
    add(l, -l);
  }
  for (long long i : ans) cout << i << ' ';
}
