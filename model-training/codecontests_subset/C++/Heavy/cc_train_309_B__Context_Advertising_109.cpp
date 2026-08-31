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
const int NN = 1000100;
char s[NN * 7];
int nxt[NN][21], len[NN], tot[NN];
int st[NN];
int main() {
  int n, r, c, cur = 0;
  gn(n, r, c);
  for (int i = 1; i <= n; i++) {
    scanf("%s", s + cur);
    st[i] = cur;
    len[i] = strlen(s + cur);
    cur += len[i];
    tot[i] = tot[i - 1] + len[i];
  }
  for (int i = 1; i <= n; i++) {
    int j = max(i, nxt[i - 1][0]);
    while (j <= n && tot[j] - tot[i - 1] + j - i <= c) j++;
    nxt[i][0] = j;
  }
  for (int i = 0; i < 21; i++) nxt[n + 1][i] = n + 1;
  for (int i = 1; i < 21; i++)
    for (int j = 1; j <= n; j++) {
      nxt[j][i] = nxt[nxt[j][i - 1]][i - 1];
    }
  int ans = 0, st = 0, ed = 0;
  for (int i = 1; i <= n; i++) {
    int k = r, u = i;
    while (k) u = nxt[u][(__builtin_ctz(k))], k ^= k & -k;
    if (u - i > ans) ans = u - i, st = i, ed = u;
  }
  if (!ans) return 0;
  int pre = 0;
  for (int i = st; i < ed; i++) {
    if (pre + len[i] > c) pre = 0, puts("");
    if (pre) putchar(' ');
    for (int j = 0; j < len[i]; j++) putchar(s[::st[i] + j]);
    pre += len[i] + 1;
  }
  puts("");
  return 0;
}
