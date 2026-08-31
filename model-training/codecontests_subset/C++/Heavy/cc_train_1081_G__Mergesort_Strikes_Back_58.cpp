#include <bits/stdc++.h>
using namespace std;
template <class T1, class T2>
inline void chkmin(T1 &x, T2 y) {
  if (y < x) x = y;
}
template <class T1, class T2>
inline void chkmax(T1 &x, T2 y) {
  if (y > x) x = y;
}
const int BUF_SIZE = 1 << 20;
char buf[BUF_SIZE], *P1 = buf, *P2 = buf, obuf[BUF_SIZE], *PO = obuf;
inline char getc() {
  if (P1 == P2) P2 = (P1 = buf) + fread(buf, 1, BUF_SIZE, stdin);
  return P1 == P2 ? EOF : *P1++;
}
inline void read(int &x) {
  register char ch = getc();
  x = 0;
  while (!isdigit(ch)) ch = getc();
  while (isdigit(ch)) x = x * 10 + (ch ^ 48), ch = getc();
}
inline void flushO() {
  fwrite(obuf, PO - obuf, 1, stdout);
  PO = obuf;
}
inline void putc(char ch) {
  if (PO == obuf + (BUF_SIZE)) flushO();
  *PO++ = ch;
}
inline void prints(char s[]) {
  for (char *ss = s; *ss != '\0'; ss++) putc(*ss);
}
inline void write(long long x) {
  if (x > 9) write(x / 10);
  putc(x % 10 ^ 48);
}
const int N = 100005;
int MOD;
inline int mo(int x) { return x >= MOD ? x - MOD : x; }
struct mint {
  int x;
  mint() {}
  mint(int a) { x = a; }
};
inline mint operator+(mint a, mint b) { return mo(a.x + b.x); }
inline mint operator+=(mint &a, mint b) { return a = a + b; }
inline mint operator-(mint a, mint b) { return mo(a.x + MOD - b.x); }
inline mint operator-(mint a) { return mo(MOD - a.x); }
inline mint operator-=(mint &a, mint b) { return a = a - b; }
inline mint operator*(mint a, mint b) { return 1ll * a.x * b.x % MOD; }
inline mint operator*=(mint &a, mint b) { return a = a * b; }
inline mint operator^(mint a, int b) {
  mint res = mint{1};
  for (; b; b >>= 1, a *= a)
    if (b & 1) res *= a;
  return res;
}
inline mint Inv(mint a) { return a ^ MOD - 2; }
inline mint operator/(mint a, mint b) { return a * Inv(b); }
inline mint operator/=(mint &a, mint b) { return a = a / b; }
int n, k, la, lb, ca, cb;
mint inv[N], sinv[N], ans;
inline void math_init(int n) {
  inv[1] = 1;
  for (int i = 2; i <= (n); i++) inv[i] = -inv[MOD % i] * (MOD / i);
  for (int i = 1; i <= (n); i++) sinv[i] = sinv[i - 1] + inv[i];
}
void solve(int l, int r, int h) {
  if (h <= 1 || l == r) {
    int len = r - l + 1;
    ans += inv[4] * len * (len - 1) + (ca * la + cb * lb) * inv[2] * len;
    for (int i = 1; i <= (len); i++)
      ans -= (sinv[la + i] - sinv[i]) * ca + (sinv[lb + i] - sinv[i]) * cb;
    if (!la) la = len;
    if (len != la && !lb) lb = len;
    if (len == la)
      ca++;
    else
      cb++;
    return;
  }
  int mid = l + r >> 1;
  solve(l, mid, h - 1);
  solve(mid + 1, r, h - 1);
}
int main() {
  scanf("%d%d%d", &n, &k, &MOD);
  math_init(max(n, 4));
  solve(1, n, k);
  printf("%d", ans);
}
