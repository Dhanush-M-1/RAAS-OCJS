#include <bits/stdc++.h>
using namespace std;
const int MAXN = (1 << 18);
int n, m;
int a, b;
struct node {
  int suma, sumb, cnt_a, cnt_b;
  node() {
    suma = 0;
    sumb = 0;
    cnt_a = 0;
    cnt_b = 0;
  }
};
node temp, broken;
node merge(node l, node r) {
  temp.cnt_a = l.cnt_a + r.cnt_a;
  temp.cnt_b = l.cnt_b + r.cnt_b;
  return temp;
}
struct segment_tree {
  set<int> stb[4 * MAXN], sta[4 * MAXN];
  node tr[4 * MAXN];
  void init(int l, int r, int idx) {
    if (l == r) {
      tr[idx] = node();
      return;
    }
    int mid = (l + r) >> 1;
    init(l, mid, 2 * idx + 1);
    init(mid + 1, r, 2 * idx + 2);
    tr[idx] = merge(tr[2 * idx + 1], tr[2 * idx + 2]);
  }
  void update(int pos, int val, int l, int r, int idx) {
    if (l > pos || r < pos) return;
    if (l == r && l == pos) {
      tr[idx].suma += val;
      tr[idx].sumb += val;
      tr[idx].cnt_a = min(a, tr[idx].suma);
      tr[idx].cnt_b = min(b, tr[idx].suma);
      return;
    }
    int mid = (l + r) >> 1;
    update(pos, val, l, mid, 2 * idx + 1);
    update(pos, val, mid + 1, r, 2 * idx + 2);
    tr[idx] = merge(tr[2 * idx + 1], tr[2 * idx + 2]);
  }
  node query(int qL, int qR, int l, int r, int idx) {
    if (l > qR || r < qL) return broken;
    if (qL <= l && r <= qR) return tr[idx];
    int mid = (l + r) >> 1;
    return merge(query(qL, qR, l, mid, 2 * idx + 1),
                 query(qL, qR, mid + 1, r, 2 * idx + 2));
  }
};
int q, k;
void read() { cin >> n >> k >> a >> b >> q; }
segment_tree t;
void solve() {
  t.init(0, n, 0);
  for (int i = 0; i < q; i++) {
    int type;
    cin >> type;
    if (type == 1) {
      int idx, val;
      cin >> idx >> val;
      t.update(idx, val, 0, n, 0);
    } else {
      int p;
      cin >> p;
      cout << t.query(0, p - 1, 0, n, 0).cnt_b +
                  t.query(p + k, n, 0, n, 0).cnt_a
           << '\n';
    }
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  read();
  solve();
  return 0;
}
