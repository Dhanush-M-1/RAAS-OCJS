#include <bits/stdc++.h>
using namespace std;
const int MAX = 2e5 + 5;
int N, K, A, B, Q;
int type, D, VAL;
int tree[MAX * 4];
int tree2[MAX * 4];
void update(int l, int r, int node, int idx, int val) {
  if (l == r) {
    tree[node] += val;
    tree2[node] += val;
    tree[node] = min(tree[node], B);
    tree2[node] = min(tree2[node], A);
  } else {
    int mid = l + r >> 1;
    if (idx <= mid)
      update(l, mid, node + node, idx, val);
    else
      update(mid + 1, r, node + node + 1, idx, val);
    tree[node] = tree[node + node] + tree[node + node + 1];
    tree2[node] = tree2[node + node] + tree2[node + node + 1];
  }
}
int query_tree(int l, int r, int node, int ql, int qr) {
  if (l > qr || r < ql || qr < ql) return 0;
  if (l >= ql && r <= qr) return tree[node];
  int mid = l + r >> 1;
  return query_tree(l, mid, node + node, ql, qr) +
         query_tree(mid + 1, r, node + node + 1, ql, qr);
}
int query_tree2(int l, int r, int node, int ql, int qr) {
  if (l > qr || r < ql || qr < ql) return 0;
  if (l >= ql && r <= qr) return tree2[node];
  int mid = l + r >> 1;
  return query_tree2(l, mid, node + node, ql, qr) +
         query_tree2(mid + 1, r, node + node + 1, ql, qr);
}
int main() {
  cin.tie(0), ios::sync_with_stdio(false);
  cin >> N >> K >> A >> B >> Q;
  for (int i = 1; i <= Q; i++) {
    cin >> type;
    if (type == 1) {
      cin >> D >> VAL;
      update(1, N, 1, D, VAL);
    } else {
      cin >> VAL;
      cout << (query_tree(1, N, 1, 1, VAL - 1) +
               query_tree2(1, N, 1, VAL + K, N))
           << '\n';
    }
  }
}
