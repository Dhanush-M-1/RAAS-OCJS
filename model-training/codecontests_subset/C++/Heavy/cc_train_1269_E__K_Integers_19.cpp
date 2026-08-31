#include <bits/stdc++.h>
using namespace std;
const long long maxn = 1e5 + 5;
const long long MAXN = 1e6 + 5;
long long n, m, t;
long long a[MAXN];
long long tree1[MAXN], tree2[MAXN];
long long pos[MAXN];
void add(long long *tree, long long x, long long xx) {
  while (x <= n) tree[x] += xx, x += (x & (-x));
}
long long query(long long *tree, long long x) {
  long long sum = 0;
  while (x > 0) sum += tree[x], x -= (x & (-x));
  return sum;
}
long long bs(long long x) {
  long long l = 1, r = n;
  long long ans;
  while (l <= r) {
    long long mid = l + r >> 1;
    if (query(tree1, mid) > x / 2)
      ans = mid, r = mid - 1;
    else
      l = mid + 1;
  }
  return ans;
}
int main() {
  cin >> n;
  for (long long i = 1; i <= n; i++) scanf("%d", &a[i]), pos[a[i]] = i;
  long long cnt = 0;
  for (long long i = 1; i <= n; i++) {
    long long ans = 0;
    add(tree1, pos[i], 1);
    add(tree2, pos[i], pos[i]);
    cnt += query(tree1, n) - query(tree1, pos[i]);
    long long tmp = bs(i);
    long long a = i / 2, b = i - a - 1;
    ans += a * tmp - query(tree2, tmp - 1) - (a + 1) * a / 2;
    long long tmpp = query(tree2, n) - query(tree2, tmp);
    ans += tmpp - b * tmp - (b + 1) * b / 2;
    cout << ans + cnt << ' ';
  }
}
