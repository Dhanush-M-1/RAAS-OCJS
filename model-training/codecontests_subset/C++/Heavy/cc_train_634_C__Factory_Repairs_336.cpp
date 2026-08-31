#include <bits/stdc++.h>
using namespace std;
long long aa[200200];
long long tree[600200];
long long tree_b[600200];
void init(int b, int e, int node) {
  if (b == e) {
    tree[node] = aa[b];
    return;
  }
  int mid = (b + e) / 2;
  int left = node * 2;
  int right = node * 2 + 1;
  init(b, mid, left);
  init(mid + 1, e, right);
  tree[node] = tree[left] + tree[right];
}
void update(int node, int b, int e, int i, long long new_val) {
  if (i > e || i < b) return;
  if (b >= i && e <= i) {
    tree[node] = new_val;
    return;
  }
  int left = node * 2;
  int right = node * 2 + 1;
  int mid = (b + e) / 2;
  update(left, b, mid, i, new_val);
  update(right, mid + 1, e, i, new_val);
  tree[node] = tree[left] + tree[right];
}
long long query(int node, int b, int e, int i, int j) {
  if (i > e || j < b) return 0;
  if (b >= i && e <= j) return tree[node];
  int left = node * 2;
  int right = node * 2 + 1;
  int mid = (b + e) / 2;
  long long p1 = query(left, b, mid, i, j);
  long long p2 = query(right, mid + 1, e, i, j);
  return p1 + p2;
}
void update_b(int node, int b, int e, int i, long long new_val) {
  if (i > e || i < b) return;
  if (b >= i && e <= i) {
    tree_b[node] = new_val;
    return;
  }
  int left = node * 2;
  int right = node * 2 + 1;
  int mid = (b + e) / 2;
  update_b(left, b, mid, i, new_val);
  update_b(right, mid + 1, e, i, new_val);
  tree_b[node] = tree_b[left] + tree_b[right];
}
long long query_b(int node, int b, int e, int i, int j) {
  if (i > e || j < b) return 0;
  if (b >= i && e <= j) return tree_b[node];
  int left = node * 2;
  int right = node * 2 + 1;
  int mid = (b + e) / 2;
  long long p1 = query_b(left, b, mid, i, j);
  long long p2 = query_b(right, mid + 1, e, i, j);
  return p1 + p2;
}
int main() {
  int n, k, a, b, q;
  cin >> n >> k >> a >> b >> q;
  for (int i = 0; i < n * 3; i++) {
    tree[i] = 0;
    tree_b[i] = 0;
  }
  for (int i = 0; i < q; i++) {
    int type;
    scanf("%d", &type);
    if (type == 1) {
      long long order;
      int day;
      scanf("%d %I64d", &day, &order);
      int dayy = day;
      if (aa[dayy] + order >= a) {
        update(1, 1, n, day, a);
      } else {
        update(1, 1, n, day, aa[dayy] + order);
      }
      if (aa[dayy] + order >= b) {
        update_b(1, 1, n, day, b);
      } else {
        update_b(1, 1, n, day, aa[dayy] + order);
      }
      aa[dayy] = aa[dayy] + order;
    } else {
      int start_day;
      scanf("%d", &start_day);
      long long bal =
          query_b(1, 1, n, 0, start_day - 1) + query(1, 1, n, start_day + k, n);
      printf("%I64d\n", bal);
    }
  }
  return 0;
}
