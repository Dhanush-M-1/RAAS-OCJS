#include <bits/stdc++.h>
using namespace std;
inline long long read() {
  long long x = 0, f = 1;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    x = (x << 3) + (x << 1) + (ch ^ '0');
    ch = getchar();
  }
  return x * f;
}
namespace BIT {
long long C[1000005];
inline void Add(long long x, long long val) {
  for (register long long i = x; i < 1000005; i += (i & (-i))) {
    C[i] += val;
  }
}
inline long long Query(long long x) {
  long long ans = 0;
  for (register long long i = x; i > 0; i -= (i & (-i))) {
    ans += C[i];
  }
  return ans;
}
};  // namespace BIT
using namespace BIT;
long long a[1000005], n;
inline long long BinSearch(long long pos) {
  long long l = 0, r = 1000005 - 1, ans;
  while (l < r - 1) {
    long long mid = (l + r) >> 1;
    if (Query(mid) <= a[pos])
      l = mid;
    else
      r = mid;
  }
  return r;
}
long long ans[1000005];
int main() {
  n = read();
  for (register long long i = 1; i <= n; ++i) a[i] = read();
  for (register long long i = 1; i <= n; ++i) {
    Add(i, i);
  }
  for (register long long i = n; i >= 1; --i) {
    long long pos = BinSearch(i);
    Add(pos, -pos);
    ans[i] = pos;
  }
  for (register long long i = 1; i <= n; ++i) {
    printf("%I64d ", ans[i]);
  }
}
