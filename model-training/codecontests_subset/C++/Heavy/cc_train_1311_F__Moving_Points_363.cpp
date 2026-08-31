#include <bits/stdc++.h>
using namespace std;
const int inf = 0x3f3f3f3f;
const long long mod = 1e9 + 7;
const long long maxn = 500010;
long long T, n, m, p[maxn], v[maxn], mxval = 0, tree[maxn], cnt[maxn], ans = 0;
struct node {
  int pos, val, v;
} a[maxn];
void add(int pos, long long val) {
  pos += n;
  cnt[pos] += 1;
  tree[pos] += val;
  while (pos) {
    pos /= 2;
    cnt[pos] = cnt[pos << 1] + cnt[pos << 1 | 1];
    tree[pos] = tree[pos << 1] + tree[pos << 1 | 1];
  }
}
pair<long long, long long> sum(int l, int r) {
  long long ret = 0, p = 0;
  for (l += n - 1, r += n + 1; l ^ r ^ 1; l /= 2, r /= 2) {
    if (~l & 1) ret += tree[l ^ 1], p += cnt[l ^ 1];
    if (r & 1) ret += tree[r ^ 1], p += cnt[r ^ 1];
  }
  return make_pair(p, ret);
}
int main() {
  scanf("%lld", &n);
  for (int i = 1; i <= n; i++) scanf("%d", &a[i].pos);
  for (int i = 1; i <= n; i++) scanf("%d", &a[i].v);
  sort(a + 1, a + 1 + n, [](node a, node b) { return a.v < b.v; });
  a[1].val = 1;
  for (int i = 2; i <= n; i++) {
    if (a[i].v > a[i - 1].v)
      a[i].val = a[i - 1].val + 1;
    else
      a[i].val = a[i - 1].val;
  }
  mxval = a[n].val;
  sort(a + 1, a + 1 + n, [](node a, node b) { return a.pos < b.pos; });
  memset(tree, 0, sizeof(tree));
  memset(cnt, 0, sizeof(cnt));
  for (int i = 1; i <= n; i++) {
    pair<long long, long long> x = sum(1, a[i].val);
    ans += x.first * a[i].pos - x.second;
    add(a[i].val, a[i].pos);
  }
  memset(tree, 0, sizeof(tree));
  memset(cnt, 0, sizeof(cnt));
  for (int i = n; i >= 1; i--) {
    pair<long long, long long> x = sum(a[i].val, mxval);
    ans += x.second - x.first * a[i].pos;
    add(a[i].val, a[i].pos);
  }
  printf("%lld\n", ans / 2);
}
