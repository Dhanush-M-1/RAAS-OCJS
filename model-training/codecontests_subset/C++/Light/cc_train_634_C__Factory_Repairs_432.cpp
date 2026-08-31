#include <bits/stdc++.h>
using namespace std;
const int MAXN = 2e5 + 5;
int N, K, A, B, Q;
int tree[2][4 * MAXN], leaf[4 * MAXN];
void update(int x, int l, int r, int p, int v) {
  if (p < l || p > r || l > r) return;
  if (l == r) {
    leaf[x] += v;
    tree[0][x] = min(leaf[x], B);
    tree[1][x] = min(leaf[x], A);
    return;
  }
  int mid = (l + r) / 2;
  if (p <= mid)
    update(2 * x, l, mid, p, v);
  else
    update(2 * x + 1, mid + 1, r, p, v);
  tree[0][x] = tree[0][2 * x] + tree[0][2 * x + 1];
  tree[1][x] = tree[1][2 * x] + tree[1][2 * x + 1];
}
int query(int x, int l, int r, bool z, int a, int b) {
  if (b < l || r < a || l > r) return 0;
  if (a <= l && r <= b) {
    if (z)
      return tree[1][x];
    else
      return tree[0][x];
  }
  int mid = (l + r) / 2;
  return query(2 * x, l, mid, z, a, b) + query(2 * x + 1, mid + 1, r, z, a, b);
}
int main() {
  ios_base::sync_with_stdio(false);
  cin >> N >> K >> A >> B >> Q;
  while (Q--) {
    int type, d, a, p;
    cin >> type;
    if (type == 1) {
      cin >> d >> a;
      update(1, 1, MAXN, d, a);
    } else {
      cin >> p;
      cout << query(1, 1, MAXN, 0, 0, p - 1) + query(1, 1, MAXN, 1, p + K, N)
           << endl;
    }
  }
  return 0;
}
