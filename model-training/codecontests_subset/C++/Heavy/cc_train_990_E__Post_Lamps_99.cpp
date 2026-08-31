#include <bits/stdc++.h>
template <typename T>
T max(T x, T y) {
  return (x > y) ? x : y;
}
template <typename T>
T min(T x, T y) {
  return (x < y) ? x : y;
}
template <typename T>
bool chkmax(T &x, T y) {
  return (x >= y) ? 0 : (x = y, 1);
}
template <typename T>
bool chkmin(T &x, T y) {
  return (x <= y) ? 0 : (x = y, 1);
}
template <typename T>
T read(T &in) {
  in = 0;
  char ch;
  T f = 1;
  while (!isdigit(ch = getchar()))
    if (ch == '-') f = -1;
  while (isdigit(ch)) in = in * 10 + ch - '0', ch = getchar();
  return in *= f;
}
static const int MAX1 = 1000000 + 11;
int n, m, k;
int s[MAX1], a[MAX1], pre[MAX1];
bool b[MAX1];
long long Get(int x) {
  int i = 0, c = 0;
  while (i < n) {
    if (b[i]) i = pre[i];
    ++c, i += x;
  }
  return 1ll * c * a[x];
}
int main() {
  read(n), read(m), read(k);
  for (int i = (1), ir = (m); i <= (ir); ++i) read(s[i]), b[s[i]] = 1;
  for (int i = (1), ir = (k); i <= (ir); ++i) read(a[i]);
  if (m && s[1] == 0) return puts("-1"), 0;
  int MAX_LEN = 0, T_LEN = 0;
  for (int i = (1), ir = (n); i <= (ir); ++i) {
    if (b[i])
      chkmax(MAX_LEN, ++T_LEN), pre[i] = pre[i - 1];
    else
      T_LEN = 0, pre[i] = i;
  }
  if (++MAX_LEN > k) return puts("-1"), 0;
  long long Ans = LONG_LONG_MAX;
  for (int i = (MAX_LEN), ir = (k); i <= (ir); ++i) chkmin(Ans, Get(i));
  printf("%lld\n", Ans);
  return 0;
}
