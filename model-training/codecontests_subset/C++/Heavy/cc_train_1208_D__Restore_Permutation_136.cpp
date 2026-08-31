#include <bits/stdc++.h>
std::vector<long long> a;
const long long INF = 1000000000000000000LL;
int lm = -1;
std::vector<long long> ts;
long long fill(int l, int r, int i) {
  if (l == r) {
    ts[i] = a[l];
    return a[l];
  }
  int m = (l + r) / 2;
  ts[i] = fill(l, m, i * 2) + fill(m + 1, r, i * 2 + 1);
  return ts[i];
}
void init(int n) {
  ts.assign(4 * n, 0);
  fill(0, n - 1, 1);
}
long long getSum(int l, int r, int cl, int cr, int i) {
  if (l == cl && r == cr) return ts[i];
  int cm = (cl + cr) / 2;
  if (r <= cm) return getSum(l, r, cl, cm, i * 2);
  if (cm < l) return getSum(l, r, cm + 1, cr, i * 2 + 1);
  return getSum(l, cm, cl, cm, i * 2) +
         getSum(cm + 1, r, cm + 1, cr, i * 2 + 1);
}
void set(int cl, int cr, int i, int ai, int val) {
  if (cl == ai && cr == ai) {
    ts[i] = a[ai] = val;
    return;
  }
  int cm = (cl + cr) / 2;
  if (ai <= cm)
    set(cl, cm, i * 2, ai, val);
  else
    set(cm + 1, cr, i * 2 + 1, ai, val);
  ts[i] = ts[i * 2] + ts[i * 2 + 1];
}
int main() {
  int n;
  scanf("%d", &n);
  std::vector<long long> s(n);
  for (long long& x : s) scanf("%I64d", &x);
  a.assign(1 + n, 0);
  for (int i = 0; i < (int)a.size(); ++i) a[i] = i;
  init(a.size());
  std::vector<int> ans(n);
  for (int i = n - 1; i >= 0; --i) {
    int l = 0, r = n + 1;
    while (r > l + 1) {
      int m = (l + r) / 2;
      long long sum = getSum(0, m, 0, n, 1);
      if (sum > s[i])
        r = m;
      else
        l = m;
    }
    ans[i] = l + 1;
    set(0, n, 1, l + 1, 0);
  }
  for (int x : ans) printf("%d ", x);
  return 0;
}
