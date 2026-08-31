#include <bits/stdc++.h>
using namespace std;
const long long mxN = 2e5 + 10;
long long a[mxN], v[mxN];
long long N;
long long ans[mxN];
void upd(long long x, long long v) {
  for (long long i = x; i <= N; i += i & -i) a[i] += v;
}
long long sum(long long x) {
  long long S = 0;
  for (long long i = x; i; i -= i & -i) S += a[i];
  return S;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cin >> N;
  for (long long i = 1; i <= N; ++i) {
    cin >> v[i];
    upd(i, i);
  }
  for (long long i = N; i; --i) {
    long long hi = N, lo = 1;
    while (lo < hi) {
      long long mid = (lo + hi) >> 1;
      long long x = sum(mid);
      if (x <= v[i])
        lo = mid + 1;
      else
        hi = mid;
    }
    ans[i] = lo;
    upd(lo, -lo);
  }
  for (int i = 1; i <= N; ++i) cout << ans[i] << " \n"[i == N];
}
