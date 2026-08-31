#include <bits/stdc++.h>
using namespace std;
const int inf = 2e5 + 9;
int n, k, a, b, q;
pair<int, int> tree[inf << 2];
void update(int node, int l, int r, int idx, int val) {
  if (l == r) {
    tree[node].first += val;
    tree[node].second += val;
    tree[node] = make_pair(min(tree[node].first, a), min(tree[node].second, b));
    return;
  }
  if (idx <= (l + r) / 2)
    update(node + node, l, (l + r) / 2, idx, val);
  else
    update(node + node + 1, (l + r) / 2 + 1, r, idx, val);
  tree[node] =
      make_pair(tree[node + node].first + tree[node + node + 1].first,
                tree[node + node].second + tree[node + node + 1].second);
}
pair<int, int> query(int node, int l, int r, int x, int y) {
  if (l > r || l > y || r < x || x > y) return make_pair(0, 0);
  if (l >= x && r <= y) return tree[node];
  pair<int, int> d = query(node + node, l, (l + r) / 2, x, y),
                 f = query(node + node + 1, (l + r) / 2 + 1, r, x, y);
  return make_pair(d.first + f.first, d.second + f.second);
}
int main() {
  cin >> n >> k >> a >> b >> q;
  while (q--) {
    int ty, x, y;
    cin >> ty >> x;
    if (ty == 1)
      cin >> y, update(1, 1, n, x, y);
    else
      cout << query(1, 1, n, 1, x - 1).second + query(1, 1, n, x + k, n).first
           << endl;
  }
}
