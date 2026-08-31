#include <bits/stdc++.h>
using namespace std;
template <class T>
inline bool getmin(T *a, const T &b) {
  if (b < *a) {
    *a = b;
    return true;
  }
  return false;
}
template <class T>
inline bool getmax(T *a, const T &b) {
  if (b > *a) {
    *a = b;
    return true;
  }
  return false;
}
template <class T>
inline void read(T *a) {
  char c;
  while (isspace(c = getchar())) {
  }
  bool flag = 0;
  if (c == '-')
    flag = 1, *a = 0;
  else
    *a = c - 48;
  while (isdigit(c = getchar())) *a = *a * 10 + c - 48;
  if (flag) *a = -*a;
}
const int mo = 1000000007;
template <class T>
T pow(T a, T b, int c = mo) {
  T res = 1;
  for (T i = 1; i <= b; i <<= 1, a = 1LL * a * a % c)
    if (b & i) res = 1LL * res * a % c;
  return res;
}
const int N = 201000;
int treeA[N * 4], treeB[N * 4];
int a, b, n, m, k;
void update(int u) {
  treeA[u] = treeA[u * 2] + treeA[u * 2 + 1];
  treeB[u] = treeB[u * 2] + treeB[u * 2 + 1];
}
void modify(int u, int L, int R, int p, int d) {
  if (L == R) {
    treeA[u] = min(treeA[u] + d, a);
    treeB[u] = min(treeB[u] + d, b);
    return;
  }
  int mid = (L + R) >> 1;
  if (p <= mid)
    modify(u * 2, L, mid, p, d);
  else
    modify(u * 2 + 1, mid + 1, R, p, d);
  update(u);
}
int queryA(int u, int L, int R, int l, int r) {
  if (l > r) return 0;
  if (l <= L && r >= R) {
    return treeA[u];
  }
  int mid = (L + R) >> 1;
  if (r <= mid)
    return queryA(u * 2, L, mid, l, r);
  else if (l > mid)
    return queryA(u * 2 + 1, mid + 1, R, l, r);
  else
    return queryA(u * 2, L, mid, l, mid) +
           queryA(u * 2 + 1, mid + 1, R, mid + 1, r);
}
int queryB(int u, int L, int R, int l, int r) {
  if (l > r) return 0;
  if (l <= L && r >= R) {
    return treeB[u];
  }
  int mid = (L + R) >> 1;
  if (r <= mid)
    return queryB(u * 2, L, mid, l, r);
  else if (l > mid)
    return queryB(u * 2 + 1, mid + 1, R, l, r);
  else
    return queryB(u * 2, L, mid, l, mid) +
           queryB(u * 2 + 1, mid + 1, R, mid + 1, r);
}
int main() {
  cin >> n >> k >> a >> b >> m;
  while (m--) {
    int com, x, y;
    read(&com);
    read(&x);
    if (com == 1) {
      read(&y);
      modify(1, 1, n, x, y);
    } else {
      printf("%d\n", queryB(1, 1, n, 1, x - 1) + queryA(1, 1, n, x + k, n));
    }
  }
  return 0;
}
