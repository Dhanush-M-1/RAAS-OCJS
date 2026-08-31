#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using ld = long double;
const int maxN = 1e6 + 10;
ll tree[4 * maxN];
int n, p[maxN];
ll s[maxN];
void update(int x, int l, int r, int k, int w) {
  if (l == r)
    tree[x] = w;
  else {
    int mid = (l + r) / 2;
    if (k <= mid)
      update(2 * x, l, mid, k, w);
    else
      update(2 * x + 1, mid + 1, r, k, w);
    tree[x] = tree[2 * x] + tree[2 * x + 1];
  }
}
void build(int x, int l, int r) {
  if (l == r)
    tree[x] = p[l];
  else {
    int mid = (l + r) / 2;
    build(2 * x, l, mid);
    build(2 * x + 1, mid + 1, r);
    tree[x] = tree[2 * x] + tree[2 * x + 1];
  }
}
ll query(int x, int l, int r, int i, int j) {
  if (l > j || r < i)
    return 0;
  else if (l >= i && r <= j)
    return tree[x];
  int mid = (l + r) / 2;
  return query(2 * x, l, mid, i, j) + query(2 * x + 1, mid + 1, r, i, j);
}
void input() {
  cin >> n;
  for (int i = int(1); i <= int(n); ++i) p[i] = i;
  for (int i = int(1); i <= int(n); ++i) cin >> s[i];
}
void solve() {
  build(1, 1, n);
  for (int i = int(n); i >= int(1); --i) {
    int l = 1, r = n + 1, mid;
    ll tmp;
    while (r - l > 1) {
      mid = (l + r) / 2;
      if (mid == 0)
        tmp = 0;
      else
        tmp = query(1, 1, n, 1, mid - 1);
      if (tmp <= s[i]) {
        l = mid;
      } else
        r = mid;
    }
    p[i] = l;
    update(1, 1, n, l, 0);
  }
}
void output() {
  for (int i = int(1); i <= int(n); ++i) cout << p[i] << " ";
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(nullptr);
  input();
  solve();
  output();
}
