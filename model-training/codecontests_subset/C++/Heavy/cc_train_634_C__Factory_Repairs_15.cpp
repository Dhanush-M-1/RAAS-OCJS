#include <bits/stdc++.h>
using namespace std;
const double EPS = 1e-9;
const double PI = acos(-1);
const int INF = (int)1e6 + 7;
const int MAXN = (int)3e6 + 7;
int n, k, a, b, m;
int t[MAXN][2];
int arr[MAXN];
void upd(int pos, int val, int v = 1, int tl = 1, int tr = n) {
  if (tl == tr) {
    arr[pos] += val;
    t[v][0] = min(a, arr[pos]);
    t[v][1] = min(b, arr[pos]);
  } else {
    int mid = (tl + tr) / 2;
    if (pos <= mid)
      upd(pos, val, v + v, tl, mid);
    else
      upd(pos, val, v + v + 1, mid + 1, tr);
    t[v][0] = t[v + v][0] + t[v + v + 1][0];
    t[v][1] = t[v + v][1] + t[v + v + 1][1];
  }
}
int get(int id, int l, int r, int v = 1, int tl = 1, int tr = n) {
  if (tl > r || tr < l) return 0;
  if (l <= tl && tr <= r) return t[v][id];
  int mid = (tl + tr) / 2;
  return get(id, l, r, v + v, tl, mid) + get(id, l, r, v + v + 1, mid + 1, tr);
}
int main() {
  scanf("%d%d%d%d%d", &n, &k, &b, &a, &m);
  while (m--) {
    int type;
    scanf("%d", &type);
    if (type == 1) {
      int where, what;
      scanf("%d%d", &where, &what);
      upd(where, what);
    } else {
      int l, r;
      scanf("%d", &l);
      r = l + k - 1;
      printf("%d\n", get(0, 1, l - 1) + get(1, r + 1, n));
    }
  }
  return 0;
}
