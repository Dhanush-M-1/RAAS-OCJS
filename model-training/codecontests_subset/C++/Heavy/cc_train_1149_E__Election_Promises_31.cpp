#include <bits/stdc++.h>
using namespace std;
inline char gc() {
  static char buf[100000], *p1 = buf, *p2 = buf;
  return p1 == p2 && (p2 = (p1 = buf) + fread(buf, 1, 100000, stdin), p1 == p2)
             ? EOF
             : *p1++;
}
inline long long read() {
  long long x = 0;
  char ch = getchar();
  bool positive = 1;
  for (; !isdigit(ch); ch = getchar())
    if (ch == '-') positive = 0;
  for (; isdigit(ch); ch = getchar()) x = x * 10 + ch - '0';
  return positive ? x : -x;
}
inline void write(long long a) {
  if (a < 0) {
    a = -a;
    putchar('-');
  }
  if (a >= 10) write(a / 10);
  putchar('0' + a % 10);
}
inline void writeln(long long a) {
  write(a);
  puts("");
}
inline void wri(long long a) {
  write(a);
  putchar(' ');
}
inline unsigned long long rnd() {
  return ((unsigned long long)rand() << 30 ^ rand()) << 4 | rand() % 4;
}
const int N = 200005;
int h[N], dp[N], vis[N], to[N], rd[N], q[N];
vector<int> f[N], g[N];
int main() {
  int n = read(), m = read();
  for (int i = (int)(1); i <= (int)(n); i++) h[i] = read();
  for (int i = (int)(1); i <= (int)(m); i++) {
    int s = read(), t = read();
    f[s].push_back(t);
    g[t].push_back(s);
    rd[s]++;
  }
  for (int i = (int)(1); i <= (int)(n); i++)
    if (!rd[i]) q[++*q] = i;
  for (int i = (int)(1); i <= (int)(*q); i++) {
    int t = q[i];
    for (auto j : f[t]) vis[dp[j]] = 1;
    for (int j = 0;; j++)
      if (!vis[j]) {
        dp[t] = j;
        to[dp[t]] ^= h[t];
        break;
      }
    for (auto j : f[t]) vis[dp[j]] = 0;
    for (auto j : g[t])
      if (--rd[j] == 0) q[++*q] = j;
  }
  for (int i = (int)(n); i >= (int)(0); i--)
    if (to[i]) {
      puts("WIN");
      for (int j = (int)(1); j <= (int)(n); j++)
        if (dp[j] == i && (h[j] ^ to[i]) < h[j]) {
          h[j] ^= to[i];
          for (auto k : f[j]) {
            h[k] ^= to[dp[k]];
            to[dp[k]] = 0;
          }
          break;
        }
      for (int i = (int)(1); i <= (int)(n); i++) wri(h[i]);
      puts("");
      return 0;
    }
  puts("LOSE");
}
