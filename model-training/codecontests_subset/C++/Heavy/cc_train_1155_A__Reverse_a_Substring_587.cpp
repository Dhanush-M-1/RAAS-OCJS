#include <bits/stdc++.h>
using namespace std;
const char IO_MODE = 0;
inline long long ReadInt() {
  long long x = 0, f = 1;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    x = x * 10 + ch - '0';
    ch = getchar();
  }
  return x * f;
}
inline void WriteInt(long long x) {
  char CH[20];
  if (x < 0) putchar('-');
  x = -x;
  int Num = 0;
  if (!x) {
    putchar('0');
    return;
  }
  while (x > 0) CH[++Num] = x % 10, x /= 10;
  while (Num) putchar(CH[Num--] + 48);
}
inline void out(int x) {
  if (IO_MODE & 1)
    WriteInt(x);
  else
    printf("%i", x);
}
template <typename... Args>
inline void out(int x, Args... args) {
  out(x);
  putc(' ', stdout);
  out(args...);
}
inline void in(int &x) {
  if (IO_MODE & 2)
    x = ReadInt();
  else
    scanf("%i", &x);
}
template <typename... Args>
inline void in(int &x, Args &...args) {
  in(x);
  in(args...);
}
inline void outll(long long x) {
  if (IO_MODE & 1)
    WriteInt(x);
  else
    printf("%I64d", x);
}
template <typename... Args>
inline void outll(long long x, Args... args) {
  outll(x);
  putc(' ', stdout);
  outll(args...);
}
inline void inll(long long &x) {
  if (IO_MODE & 2)
    x = ReadInt();
  else
    scanf("%I64d", &x);
}
template <typename... Args>
inline void inll(long long &x, Args &...args) {
  inll(x);
  inll(args...);
}
int aa, bb, cc, dd, ee, ff, gg, hh, ii, jj, kk, mm, nn, oo, pp, qq, rr, ss, tt,
    uu, vv, ww, xx, yy, zz;
int tc;
int n, occ[33];
string s;
int main() {
  cin >> n >> s;
  for (int i = 0; i < n; i++) {
    int x = s[i] - 'a';
    for (int j = 26; j > x; j--) {
      if (occ[j]) {
        printf("YES"), putc('\n', stdout);
        cout << occ[j] << " " << i + 1 << endl;
        return 0;
      }
    }
    occ[x] = i + 1;
  }
  printf("NO"), putc('\n', stdout);
}
