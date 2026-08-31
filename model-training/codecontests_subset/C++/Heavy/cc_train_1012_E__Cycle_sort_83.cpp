#include <bits/stdc++.h>
using namespace std;
char buf[25];
const int maxn = 200010;
struct node {
  int w, id;
} c[maxn], d[maxn];
vector<int> v[maxn];
int a[maxn], b[maxn], f[maxn], q[maxn];
bool p[maxn];
int n, m, s, ans;
int read() {
  int x = 0, f = 0;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') f = 1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    x = (x << 1) + (x << 3) + (ch ^ 48);
    ch = getchar();
  }
  return f ? -x : x;
}
void write(int x) {
  if (!x) {
    putchar('0');
    return;
  }
  if (x < 0) {
    putchar('-');
    x = -x;
  }
  int cnt = 0;
  while (x) {
    buf[++cnt] = '0' + x % 10;
    x /= 10;
  }
  for (int i = cnt; i >= 1; --i) putchar(buf[i]);
}
bool cmp(node x, node y) { return x.w < y.w; }
int find(int x) {
  if (f[x] != x) f[x] = find(f[x]);
  return f[x];
}
void unions(int x, int y) {
  int l = find(x), r = find(y);
  if (l != r) f[l] = r;
}
int main() {
  n = read();
  s = read();
  for (int i = 1; i <= n; ++i) {
    a[i] = b[i] = read();
  }
  sort(b + 1, b + 1 + n);
  for (int i = 1; i <= n; ++i)
    if (a[i] != b[i]) {
      ++m;
      c[m] = d[m] = (node){a[i], i};
    }
  if (m > s) {
    puts("-1");
    return 0;
  }
  sort(d + 1, d + 1 + m, cmp);
  for (int i = 1; i <= m; ++i) f[c[i].id] = c[i].id;
  for (int i = 1; i <= m; ++i) unions(d[i].id, c[i].id);
  for (int i = 2; i <= m; ++i)
    if (d[i].w == d[i - 1].w && find(d[i].id) != find(d[i - 1].id)) {
      swap(d[i], d[i - 1]);
      unions(d[i].id, d[i - 1].id);
    }
  for (int i = 1; i <= m; ++i) q[d[i].id] = c[i].id, p[d[i].id] = true;
  for (int i = 1; i <= m; ++i) {
    int x = c[i].id;
    if (p[x]) {
      ++ans;
      while (p[x]) {
        p[x] = false;
        v[ans].push_back(x);
        x = q[x];
      }
    }
  }
  int num = min(ans, s - m);
  if (num > 2) {
    write(ans - (num - 2));
    putchar('\n');
    int sum = 0;
    for (int i = 1; i <= num; ++i) sum += v[i].size();
    write(sum);
    putchar('\n');
    for (int i = 1; i <= num; ++i) {
      for (int j = 0; j <= v[i].size() - 1; ++j) {
        write(v[i][j]);
        if (i != num || j != v[i].size() - 1)
          putchar(' ');
        else
          putchar('\n');
      }
    }
    write(num);
    putchar('\n');
    for (int i = num; i >= 1; --i) {
      write(v[i][0]);
      if (i != 1)
        putchar(' ');
      else
        putchar('\n');
    }
    for (int i = num + 1; i <= ans; ++i) {
      write(v[i].size());
      putchar('\n');
      for (int j = 0; j <= v[i].size() - 1; ++j) {
        write(v[i][j]);
        if (j != v[i].size() - 1)
          putchar(' ');
        else
          putchar('\n');
      }
    }
  } else {
    write(ans);
    putchar('\n');
    for (int i = 1; i <= ans; ++i) {
      write(v[i].size());
      putchar('\n');
      for (int j = 0; j <= v[i].size() - 1; ++j) {
        write(v[i][j]);
        if (j != v[i].size() - 1)
          putchar(' ');
        else
          putchar('\n');
      }
    }
  }
  return 0;
}
