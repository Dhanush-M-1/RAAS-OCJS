#include <bits/stdc++.h>
using namespace std;
const long long mod = 1e9 + 7;
const double eps = 1e-15;
double PI = 3.14159265359;
const int INF = 1e9;
const int N = 200005;
long long n, k, a, b, q;
long long x, y, z;
struct Node {
  long long val;
  long long suma, sumb;
  Node() {}
  Node(long long val) {
    this->val = val;
    suma = min(val, a);
    sumb = min(val, b);
  }
  Node merge(Node n1) {
    Node nn = Node();
    nn.suma = this->suma + n1.suma;
    nn.sumb = this->sumb + n1.sumb;
    return nn;
  }
};
Node tree[N * 4];
void build(int node, int l, int r) {
  if (l == r) {
    tree[node] = Node(0);
    return;
  }
  int mid = (l + r) >> 1;
  build(node << 1, l, mid);
  build(node << 1 | 1, mid + 1, r);
  tree[node] = tree[node << 1].merge(tree[node << 1 | 1]);
}
void insert(int node, int l, int r, int idx, long long val) {
  if (l == r) {
    tree[node] = Node(val + tree[node].val);
    return;
  }
  int mid = (l + r) >> 1;
  if (idx <= mid)
    insert(node << 1, l, mid, idx, val);
  else
    insert(node << 1 | 1, mid + 1, r, idx, val);
  tree[node] = tree[node << 1].merge(tree[node << 1 | 1]);
}
long long query(int node, int l, int r, int ll, int rr, int type) {
  if (l > rr || r < ll || ll > rr || l > r) return 0;
  if (l >= ll && r <= rr) {
    if (type)
      return tree[node].suma;
    else
      return tree[node].sumb;
  }
  int mid = (l + r) >> 1;
  long long q1 = query(node << 1, l, mid, ll, rr, type);
  long long q2 = query(node << 1 | 1, mid + 1, r, ll, rr, type);
  return q1 + q2;
}
int main() {
  ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  cin >> n >> k >> a >> b >> q;
  while (q--) {
    cin >> x >> y;
    if (x & 1) {
      cin >> z;
      insert(1, 1, n, y, z);
    } else {
      long long res1 = query(1, 1, n, 1, y - 1, 0);
      long long res2 = query(1, 1, n, y + k, n, 1);
      cout << res1 + res2 << "\n";
    }
  }
}
