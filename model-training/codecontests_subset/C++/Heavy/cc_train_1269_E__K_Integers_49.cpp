#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 10;
int n;
int pos[maxn];
long long sum1[maxn], sum2[maxn];
int lowbit(int x) { return x & -x; }
void add(long long *sum, int x, long long v) {
  while (x <= n) {
    sum[x] += v;
    x += lowbit(x);
  }
}
long long query(long long *sum, int x) {
  long long ans = 0;
  while (x > 0) {
    ans += sum[x];
    x -= lowbit(x);
  }
  return ans;
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    int p;
    scanf("%d", &p);
    pos[p] = i;
  }
  long long rev = 0;
  for (int i = 1; i <= n; i++) {
    add(sum1, pos[i], 1);
    add(sum2, pos[i], pos[i]);
    rev += i - query(sum1, pos[i]);
    int l = 1, r = n, mid = (l + r) >> 1;
    while (l < r) {
      if (query(sum1, mid) <= i / 2)
        l = mid + 1;
      else
        r = mid;
      mid = (l + r) >> 1;
    }
    long long cntl = query(sum1, mid) - 1, cntr = i - cntl - 1;
    long long ans = 1LL * mid * (cntl - cntr + 1) + query(sum2, n) -
                    2 * query(sum2, mid) - (cntl + 1) * cntl / 2 -
                    (cntr + 1) * cntr / 2;
    ans += rev;
    printf("%lld ", ans);
  }
  return 0;
}
