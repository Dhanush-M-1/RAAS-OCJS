#include <bits/stdc++.h>
using namespace std;
const int M = 2e5 + 5;
int p[M << 2], res[M];
long long V[M << 2], tag[M << 2];
void push_up(int o) {
  if (V[o << 1] < V[o << 1 | 1]) {
    V[o] = V[o << 1];
    p[o] = p[o << 1];
  } else {
    V[o] = V[o << 1 | 1];
    p[o] = p[o << 1 | 1];
  }
}
void push_down(int o) {
  tag[o << 1] += tag[o];
  tag[o << 1 | 1] += tag[o];
  V[o << 1] += tag[o];
  V[o << 1 | 1] += tag[o];
  tag[o] = 0;
}
void build(int o, int l, int r) {
  if (l == r) {
    scanf("%lld", &V[o]);
    p[o] = l;
    return;
  }
  int mid = (l + r) / 2;
  build(o << 1, l, mid);
  build(o << 1 | 1, mid + 1, r);
  push_up(o);
}
void upd(int o, int l, int r, int L, int R, long long x) {
  if (L > R) return;
  if (L <= l && r <= R) {
    tag[o] += x;
    V[o] += x;
    return;
  }
  int mid = (l + r) / 2;
  push_down(o);
  if (L <= mid) upd(o << 1, l, mid, L, R, x);
  if (R > mid) upd(o << 1 | 1, mid + 1, r, L, R, x);
  push_up(o);
}
int main() {
  int n;
  scanf("%d", &n);
  build(1, 1, n);
  for (int i = 1; i <= n; i++) {
    int pos = p[1];
    res[pos] = i;
    upd(1, 1, n, pos, pos, 1e11);
    upd(1, 1, n, pos + 1, n, -i);
  }
  for (int i = 1; i <= n; i++) {
    printf("%d ", res[i]);
  }
  return 0;
}
