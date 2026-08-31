#include <bits/stdc++.h>
using namespace std;
const long long maxn = 2e5 + 10;
long long sum1[maxn];
long long sum2[maxn];
long long n;
long long lowbit(long long x) { return x & -x; }
void add(long long *sum, long long x, long long v) {
  while (x <= n) {
    sum[x] += v;
    x += lowbit(x);
  }
}
long long query(long long *sum, long long x) {
  long long res = 0;
  while (x > 0) {
    res += sum[x];
    x -= lowbit(x);
  }
  return res;
}
long long a[maxn];
long long pos[maxn];
signed main() {
  scanf("%lld", &n);
  for (long long i = 1; i <= n; i++) {
    scanf("%lld", &a[i]);
    pos[a[i]] = i;
  }
  long long ans1 = 0;
  for (long long i = 1; i <= n; i++) {
    ans1 += i - 1 - query(sum1, pos[i]);
    add(sum1, pos[i], 1);
    add(sum2, pos[i], pos[i]);
    long long mid, l = 1, r = n;
    while (l <= r) {
      mid = (l + r) >> 1;
      if (query(sum1, mid) * 2 <= i) {
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
    long long ans2 = 0;
    long long cnt = query(sum1, mid), sum = query(sum2, mid);
    ans2 += mid * cnt - sum - cnt * (cnt - 1) / 2;
    cnt = i - cnt, sum = query(sum2, n) - sum;
    ans2 += sum - cnt * (mid + 1) - cnt * (cnt - 1) / 2;
    printf("%lld ", ans1 + ans2);
  }
  puts("");
  return 0;
}
