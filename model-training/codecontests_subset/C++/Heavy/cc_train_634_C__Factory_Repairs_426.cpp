#include <bits/stdc++.h>
using namespace std;
const long long INF = 1e18 + 1;
inline long long input(void) {
  char t;
  long long x = 0;
  int neg = 0;
  t = getchar();
  while ((t < 48 || t > 57) && t != '-') t = getchar();
  if (t == '-') {
    neg = 1;
    t = getchar();
  }
  while (t >= 48 && t <= 57) {
    x = (x << 3) + (x << 1) + t - 48;
    t = getchar();
  }
  if (neg) x = -x;
  return x;
}
inline void output(long long x) {
  char a[20];
  int i = 0, j;
  a[0] = '0';
  if (x < 0) {
    putchar('-');
    x = -x;
  }
  if (x == 0) putchar('0');
  while (x) {
    a[i++] = x % 10 + 48;
    x /= 10;
  }
  for (j = i - 1; j >= 0; j--) {
    putchar(a[j]);
  }
  putchar('\n');
}
long long Tree[1000010][2], a, b;
inline void maketree(int vertex, int idx, int l, int r) {
  if (l == r) {
    Tree[vertex][idx] = 0;
    return;
  }
  int m = (l + r) / 2, left = 2 * vertex, right = left + 1;
  maketree(left, idx, l, m);
  maketree(right, idx, m + 1, r);
  Tree[vertex][idx] = 0;
  return;
}
inline void update(int vertex, int idx, int l, int r, int index, int value) {
  if (l == r) {
    Tree[vertex][idx] += value;
    if (idx == 0 && Tree[vertex][idx] > a)
      Tree[vertex][idx] = a;
    else if (idx == 1 && Tree[vertex][idx] > b)
      Tree[vertex][idx] = b;
    return;
  }
  int m = (l + r) / 2, left = 2 * vertex, right = left + 1;
  if (index > m)
    update(right, idx, m + 1, r, index, value);
  else
    update(left, idx, l, m, index, value);
  Tree[vertex][idx] = Tree[left][idx] + Tree[right][idx];
  return;
}
inline long long query(int vertex, int idx, int l, int r, int u, int v) {
  if (l == u && r == v) return Tree[vertex][idx];
  int m = (l + r) / 2, left = 2 * vertex, right = left + 1;
  if (v <= m) return query(left, idx, l, m, u, v);
  if (u > m) return query(right, idx, m + 1, r, u, v);
  long long a, b;
  a = query(left, idx, l, m, u, m);
  b = query(right, idx, m + 1, r, m + 1, v);
  return (a + b);
}
int main() {
  long long n, k, q, type, x, d, p, ans, sz;
  n = input();
  k = input();
  a = input();
  b = input();
  q = input();
  maketree(1, 0, 0, n - 1);
  maketree(1, 1, 0, n - 1);
  while (q--) {
    type = input();
    if (type == 1) {
      d = input();
      d -= 1;
      x = input();
      update(1, 0, 0, n - 1, d, x);
      update(1, 1, 0, n - 1, d, x);
    } else {
      p = input();
      p -= 1;
      ans = 0;
      sz = p;
      if (sz) ans += query(1, 1, 0, n - 1, 0, p - 1);
      sz = n - p - k;
      if (sz) ans += query(1, 0, 0, n - 1, p + k, n - 1);
      output(ans);
    }
  }
  return 0;
}
