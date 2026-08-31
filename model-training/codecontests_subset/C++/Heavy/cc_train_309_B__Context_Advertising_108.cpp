#include <bits/stdc++.h>
using namespace std;
template <typename T, typename U>
inline void smin(T &a, U b) {
  if (a > b) a = b;
}
template <typename T, typename U>
inline void smax(T &a, U b) {
  if (a < b) a = b;
}
template <class T>
inline void gn(T &first) {
  char c, sg = 0;
  while (c = getchar(), (c > '9' || c < '0') && c != '-')
    ;
  for ((c == '-' ? sg = 1, c = getchar() : 0), first = 0; c >= '0' && c <= '9';
       c = getchar())
    first = (first << 1) + (first << 3) + c - '0';
  if (sg) first = -first;
}
template <class T, class T1>
inline void gn(T &first, T1 &second) {
  gn(first);
  gn(second);
}
template <class T, class T1, class T2>
inline void gn(T &first, T1 &second, T2 &z) {
  gn(first);
  gn(second);
  gn(z);
}
template <class T>
inline void print(T first) {
  if (first < 0) {
    putchar('-');
    return print(-first);
  }
  if (first < 10) {
    putchar('0' + first);
    return;
  }
  print(first / 10);
  putchar(first % 10 + '0');
}
template <class T>
inline void printsp(T first) {
  print(first);
  putchar(' ');
}
template <class T>
inline void println(T first) {
  print(first);
  putchar('\n');
}
template <class T, class U>
inline void print(T first, U second) {
  printsp(first);
  println(second);
}
template <class T, class U, class V>
inline void print(T first, U second, V z) {
  printsp(first);
  printsp(second);
  println(z);
}
int power(int a, int b, int m, int ans = 1) {
  for (; b; b >>= 1, a = 1LL * a * a % m)
    if (b & 1) ans = 1LL * ans * a % m;
  return ans;
}
const int B = 6555555, BB = 1111111;
char s[B];
int a[BB], sum[BB], len[BB], tmp[BB], ans, r, cnt, ansv[BB], vst[BB];
vector<int> adj[BB];
void dfs(int u, int fa, int dp = -1) {
  vst[u] = 1;
  tmp[++dp] = u;
  if (dp) {
    len[dp] = len[dp - 1] + fa - u;
    if (ans < len[dp] - len[max(0, dp - r)]) {
      ans = len[dp] - len[max(0, dp - r)];
      cnt = max(0, dp - r);
      int t = 0;
      for (int i = dp; i >= cnt; i--) ansv[t++] = tmp[i];
      cnt = dp - cnt;
    }
  }
  for (int i = 0; i < adj[u].size(); i++) {
    int v = adj[u][i];
    if (vst[v]) continue;
    dfs(v, u, dp);
  }
}
char *ss[BB];
void solve_B() {
  int n, c;
  gn(n, r, c);
  c++;
  gets(s);
  char *p = strtok(s, " ");
  n = 1;
  while (p) {
    ss[n] = p;
    a[n++] = strlen(p) + 1;
    p = strtok(NULL, " ");
  }
  for (int i = 1; i < n; i++) sum[i] = sum[i - 1] + a[i];
  int pos = 1;
  for (int i = 1; i < n; i++) {
    smax(pos, i);
    while (pos < n && sum[pos] - sum[i - 1] <= c) pos++;
    if (pos > i) adj[pos].push_back(i);
  }
  for (int i = n + 1; i > 0; i--)
    if (!vst[i]) dfs(i, i);
  for (int i = 0; i < cnt; i++) {
    for (int j = ansv[i]; j < ansv[i + 1] - 1; j++) printf("%s ", ss[j]);
    printf("%s\n", ss[ansv[i + 1] - 1]);
  }
}
int main() {
  solve_B();
  return 0;
}
