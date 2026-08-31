#include <bits/stdc++.h>
using namespace std;
long long BIT[2][202001];
int n;
void update(long long tree[202001], int p, int v) {
  for (; p <= n; p += p & -p) {
    tree[p] += v;
  }
}
long long query(long long tree[202001], int p) {
  long long ret = 0;
  while (p) {
    ret += tree[p];
    p -= p & -p;
  }
  return ret;
}
long long query(long long tree[202001], int a, int b) {
  if (a > b) return 0LL;
  return query(tree, b) - query(tree, a - 1);
}
int type, k, a, b, q, x, y, tmp;
int t[202001];
int main() {
  ios::sync_with_stdio(false);
  cin >> n >> k >> a >> b >> q;
  for (int i = 0; i < q; ++i) {
    cin >> type >> x;
    if (type == 1) {
      cin >> y;
      if ((tmp = (min(t[x] + y, b) - t[x])) > 0) update(BIT[0], x, tmp);
      if ((tmp = (min(t[x] + y, a) - t[x])) > 0) update(BIT[1], x, tmp);
      t[x] = min(t[x] + y, a);
    } else {
      cout << (query(BIT[0], x - 1) + query(BIT[1], x + k, n)) << '\n';
    }
  }
  return 0;
}
