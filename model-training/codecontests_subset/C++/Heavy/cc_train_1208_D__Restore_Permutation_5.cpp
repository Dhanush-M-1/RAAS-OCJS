#include <bits/stdc++.h>
using namespace std;
long long int ar[4 * 200005];
void update(int a, int b, int l, int h, int p) {
  if (a < l || a > h) return;
  if (l == h) {
    ar[p] += b;
    return;
  }
  int m = (l + h) / 2;
  update(a, b, l, m, 2 * p);
  update(a, b, m + 1, h, 2 * p + 1);
  ar[p] += b;
  return;
}
int query(int l, int h, int p, long long int s) {
  if (l == h) return l;
  int m = (l + h) / 2;
  if (ar[2 * p] > s)
    return query(l, m, 2 * p, s);
  else
    return query(m + 1, h, 2 * p + 1, s - ar[2 * p]);
}
int compute(long long int s) {
  int x;
  s *= 2;
  x = sqrt(s);
  return x + 1;
}
int main() {
  int i, n;
  scanf("%d", &n);
  vector<long long int> sum(n);
  for (i = 0; i < n; i++) cin >> sum[i];
  vector<int> ans(n);
  ans[n - 1] = compute(sum[n - 1]);
  for (i = 1; i < n + 1; i++) update(i, i, 0, n, 1);
  update(ans[n - 1], -ans[n - 1], 0, n, 1);
  for (i = n - 2; i >= 0; i--) {
    ans[i] = query(0, n, 1, sum[i]);
    update(ans[i], -ans[i], 0, n, 1);
  }
  for (i = 0; i < n; i++) printf("%d ", ans[i]);
  printf("\n");
}
