#include <bits/stdc++.h>
using namespace std;
int n, k, a, b, q;
vector<int> arr;
vector<pair<int, int>> st;
int left(int p) { return p << 1; }
int right(int p) { return (p << 1) + 1; }
void bu(int p, int l, int r) {
  if (l == r) {
    int aux_a = (arr[l] >= a) ? a : arr[l];
    int aux_b = (arr[l] >= b) ? b : arr[l];
    st[p] = make_pair(aux_a, aux_b);
  } else {
    int mid = (l + r) / 2;
    bu(left(p), l, mid);
    bu(right(p), mid + 1, r);
    pair<int, int> p1 = st[left(p)], p2 = st[right(p)];
    st[p] = make_pair(p1.first + p2.first, p1.second + p2.second);
  }
}
void build() { bu(1, 0, n - 1); }
int qa(int p, int l, int r, int i, int j) {
  if (i > r || j < l) return 0;
  if (l >= i && r <= j) return st[p].first;
  int mid = (l + r) / 2;
  int p1 = qa(left(p), l, mid, i, j);
  int p2 = qa(right(p), mid + 1, r, i, j);
  return p1 + p2;
}
int qb(int p, int l, int r, int i, int j) {
  if (i > r || j < l) return 0;
  if (l >= i && r <= j) return st[p].second;
  int mid = (l + r) / 2;
  int p1 = qb(left(p), l, mid, i, j);
  int p2 = qb(right(p), mid + 1, r, i, j);
  return p1 + p2;
}
int query_a(int i, int j) {
  if (i <= j)
    return qa(1, 0, n - 1, i, j);
  else
    return 0;
}
int query_b(int i, int j) {
  if (i <= j)
    return qb(1, 0, n - 1, i, j);
  else
    return 0;
}
void u(int p, int l, int r, int i, int v) {
  if (l == r) {
    int aux_a = (st[p].first + v >= a) ? a : st[p].first + v;
    int aux_b = (st[p].second + v >= b) ? b : st[p].second + v;
    st[p] = make_pair(aux_a, aux_b);
  } else {
    int mid = (l + r) / 2;
    if (i <= mid)
      u(left(p), l, mid, i, v);
    else
      u(right(p), mid + 1, r, i, v);
    pair<int, int> p1 = st[left(p)], p2 = st[right(p)];
    st[p] = make_pair(p1.first + p2.first, p1.second + p2.second);
  }
}
void update(int i, int v) { u(1, 0, n - 1, i, v); }
int main() {
  cin >> n >> k >> a >> b >> q;
  arr.assign(n, 0);
  st.assign(4 * n, make_pair(0, 0));
  for (int i = 0; i < q; i++) {
    int op, day, orders;
    cin >> op;
    if (op == 1) {
      cin >> day >> orders;
      day--;
      update(day, orders);
    } else {
      cin >> day;
      day--;
      cout << query_b(0, day - 1) + query_a(day + k, n - 1) << endl;
    }
  }
  return 0;
}
