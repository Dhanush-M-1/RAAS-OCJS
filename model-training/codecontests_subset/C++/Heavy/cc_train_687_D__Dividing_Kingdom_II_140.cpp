#include <bits/stdc++.h>
using namespace std;
namespace IO {
void read(int &x) {
  x = 0;
  int f = 1;
  char c = getchar();
  while ('0' > c || c > '9') {
    if (c == '-') f = -1;
    c = getchar();
  }
  while ('0' <= c && c <= '9') {
    x = (x << 3) + (x << 1) + c - '0';
    c = getchar();
  }
  x *= f;
}
void write(int x) {
  if (x < 0) {
    putchar('-');
    write(-x);
    return;
  }
  if (x < 10)
    putchar(x + '0');
  else {
    write(x / 10);
    putchar(x % 10 + '0');
  }
}
}  // namespace IO
namespace ufs {
int fa[2005];
int w[2005];
void makeset(int n) {
  for (int i = 1; i <= n; i++) {
    fa[i] = i;
    w[i] = 0;
  }
}
int findset(int x) {
  if (fa[x] == x) return x;
  int t = findset(fa[x]);
  w[x] ^= w[fa[x]];
  return fa[x] = t;
}
void merge(int u, int v, int ty) {
  int a = findset(u);
  int b = findset(v);
  fa[a] = b;
  w[a] = w[u] ^ ty ^ w[v];
  w[b] = 0;
}
}  // namespace ufs
using namespace IO;
using namespace ufs;
int n, m, q;
struct node {
  int u, v, w, id;
  friend bool operator<(const node &a, const node &b) { return a.w < b.w; }
} e[5000005];
int main() {
  read(n);
  read(m);
  read(q);
  for (int i = 1, u, v, w; i <= m; i++) {
    read(u);
    read(v);
    read(w);
    e[i] = (node){u, v, w, i};
  }
  sort(e + 1, e + m + 1);
  for (int i = 1, l, r; i <= q; i++) {
    read(l);
    read(r);
    bool f = 1;
    makeset(n * 2);
    for (int j = m; j >= 1; j--) {
      if (l <= e[j].id && e[j].id <= r) {
        if (findset(e[j].u) == findset(e[j].v)) {
          if ((w[e[j].u] ^ w[e[j].v]) != 1) {
            f = 0;
            write(e[j].w);
            putchar('\n');
            break;
          }
        } else
          merge(e[j].u, e[j].v, 1);
      }
    }
    if (f) {
      write(-1);
      putchar('\n');
    }
  }
  return 0;
}
