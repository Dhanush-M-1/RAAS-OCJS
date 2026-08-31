#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 5;
int n, m, pos, v[N];
long long tot, s[N][2];
struct node {
  long long x, v;
} a[N];
bool cmp(node x, node y) { return x.x < y.x; }
int lowbit(int x) { return x & (-x); }
void update(int x, int val) {
  while (x <= n) {
    s[x][0]++;
    s[x][1] += val;
    x += lowbit(x);
  }
}
long long getsum(int x, int flag) {
  long long res = 0;
  while (x) {
    res += s[x][flag];
    x -= lowbit(x);
  }
  return res;
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%lld", &a[i].x);
  for (int i = 1; i <= n; i++) {
    scanf("%lld", &a[i].v);
    v[i] = a[i].v;
  }
  sort(a + 1, a + n + 1, cmp);
  sort(v + 1, v + n + 1);
  m = unique(v + 1, v + n + 1) - v - 1;
  for (int i = 1; i <= n; i++) {
    pos = lower_bound(v + 1, v + m + 1, a[i].v) - v;
    tot += getsum(pos, 0) * a[i].x - getsum(pos, 1);
    update(pos, a[i].x);
  }
  printf("%lld", tot);
  return 0;
}
