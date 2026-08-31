#include <bits/stdc++.h>
using namespace std;
template <typename T>
void read(T& n) {
  char ch;
  int sign = 1;
  while (!isdigit(ch = getchar()))
    if (ch == '-') sign = -1;
  n = ch - '0';
  while (isdigit(ch = getchar())) n = n * 10 + ch - '0';
  n *= sign;
}
const int INF = 1e9 + 7;
const int N = 122222;
int n, k, ans(1);
long double a[N], b[N], first[N];
struct edge {
  int to, nxt;
  long double k;
} g[N * 4];
int ghead[N], gtail(0);
void add(int l, int r, long double k) {
  g[++gtail] = (edge){r, ghead[l], k}, ghead[l] = gtail;
}
long double dfs(int first) {
  long double pos = 0, neg = 0;
  for (int p = ghead[first]; p; p = g[p].nxt) {
    int v = g[p].to;
    long double tmp = dfs(v);
    if (tmp < 0)
      neg -= tmp * g[p].k;
    else
      pos += tmp;
  }
  return a[first] + pos - b[first] - neg;
}
int main() {
  read(n);
  for (int i = (1); i <= (n); ++i) read(a[i]);
  for (int i = (1); i <= (n); ++i) read(b[i]);
  for (int i = (2); i <= (n); ++i) read(first[i]), read(k), add(first[i], i, k);
  puts(dfs(1) >= 0 ? "Yes" : "No");
  return 0;
}
