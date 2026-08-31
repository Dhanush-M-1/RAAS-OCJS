#include <bits/stdc++.h>
using namespace std;
int T;
long long n;
long long a[333333];
long long twosum[333333];
long long tree[(1LL << 18) * 3];
long long ans[333333];
set<long long> s;
void update(long long x, long long y) {
  x += (1LL << 18);
  while (x > 0LL) {
    tree[x] += y;
    x /= 2LL;
  }
}
long long sum(int s, int e, int ns = 0, int ne = (1LL << 18) - 1, int idx = 1) {
  if (s > ne || ns > e) return 0LL;
  if (s <= ns && ne <= e) return tree[idx];
  int mid = (ns + ne) / 2;
  return sum(s, e, ns, mid, idx * 2) + sum(s, e, mid + 1, ne, idx * 2 + 1);
}
int main() {
  scanf("%lld", &n);
  for (long long i = 1LL; i <= n; i++) {
    scanf("%lld", &a[i]);
    twosum[i] = twosum[i - 1] + i;
    s.insert(i);
    update(i, i);
  }
  for (long long i = n; i > 0; i--) {
    long long st = 1LL;
    long long ed = n;
    long long val;
    while (st <= ed) {
      long long mid = (st + ed) / 2LL;
      if (sum(1, (int)mid - 1) <= a[i]) {
        st = mid + 1LL;
        val = mid;
      } else
        ed = mid - 1LL;
    }
    val = *s.lower_bound(val);
    update(val, -val);
    s.erase(val);
    ans[i] = val;
  }
  for (int i = 1; i <= n; i++) printf("%d ", ans[i]);
  return 0;
}
