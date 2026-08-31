#include <bits/stdc++.h>
using namespace std;
template <class T>
inline void read(T& num) {
  num = 0;
  bool f = 1;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') f = 0;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    num = num * 10 + ch - '0';
    ch = getchar();
  }
  num = f ? num : -num;
}
template <class T>
inline void write(T x, char ch) {
  int s[100];
  if (x == 0) {
    putchar('0');
    putchar(ch);
    return;
  }
  if (x < 0) {
    putchar('-');
    x = -x;
  }
  int num = 0;
  while (x) {
    s[num++] = (x % 10);
    x = x / 10;
  }
  for (int i = (num - 1); i >= (0); i--) putchar(s[i] + '0');
  putchar(ch);
}
int n, tot, siz;
int d[3005], d2[3005], last[3005];
double ans;
bool v[3005];
struct hh {
  int next, to;
} e[7005];
queue<int> q;
void add(int a, int b) {
  e[++tot].to = b;
  e[tot].next = last[a];
  last[a] = tot;
}
void insert(int a, int b) {
  add(a, b);
  add(b, a);
}
void dfs(int now) {
  int i, j;
  v[now] = true;
  for (i = last[now]; i; i = e[i].next)
    if (!v[e[i].to]) {
      d2[e[i].to] = d2[now] + 1;
      if (!d[e[i].to])
        d[e[i].to] = d[now] + 1, ans += 1.0 / d[e[i].to];
      else
        ans += 1.0 / d2[e[i].to] - 2.0 / (d[e[i].to] + d2[e[i].to] + siz - 2);
      dfs(e[i].to);
    }
  v[now] = false;
}
int main() {
  int i, j, u, v, now;
  read(n);
  siz = n;
  for (i = 1; i <= n; i++) {
    read(u);
    read(v);
    u++;
    v++;
    d[u]++;
    d[v]++;
    insert(u, v);
  }
  for (i = 1; i <= n; i++)
    if (d[i] == 1) q.push(i);
  while (!q.empty()) {
    now = q.front();
    q.pop();
    siz--;
    for (i = last[now]; i; i = e[i].next)
      if (--d[e[i].to] == 1) q.push(e[i].to);
  }
  for (i = 1; i <= n; i++) {
    memset(d, 0, sizeof(d));
    memset(d2, 0, sizeof(d2));
    d[i] = d2[i] = 1;
    dfs(i);
  }
  printf("%lf", ans + (double)n);
  return 0;
}
