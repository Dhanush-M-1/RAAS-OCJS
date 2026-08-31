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
const int N = 100005;
int ycl[N], tong[N], mod, inv;
void solve(int l, int r, int dep) {
  if (l == r || dep == 1) {
    tong[r - l + 1]++;
    return;
  }
  int mid = (l + r) >> 1;
  solve(l, mid, dep - 1);
  solve(mid + 1, r, dep - 1);
}
long long get(long long len) { return len * (len - 1) / 2 % mod * inv % mod; }
inline long long ksm(long long a, int b) {
  int ans = 1;
  for (; b; b >>= 1) {
    if (b & 1) ans = ans * a % mod;
    a = a * a % mod;
  }
  return ans;
}
int n, k;
long long get(long long a, long long b) {
  if (a + b > n) return 0;
  long long ans = 0;
  for (int i = 1; i <= a; i++) {
    ans = (ans + inv * b - ycl[i + b] + ycl[i]) % mod;
  }
  return (ans + mod) % mod;
}
int main() {
  cin >> n >> k >> mod;
  inv = (mod + 1) / 2;
  for (int i = 1; i <= n; i++) ycl[i] = (ycl[i - 1] + ksm(i, mod - 2)) % mod;
  solve(1, n, k);
  for (int i = 1; i <= n; i++)
    if (tong[i]) {
      cout << (get(i) * tong[i] + get(i + 1) * tong[i + 1] +
               get(i, i + 1) * tong[i] % mod * tong[i + 1] +
               tong[i] * (tong[i] - 1) / 2 % mod * get(i, i) +
               tong[i + 1] * (tong[i + 1] - 1) / 2 % mod * get(i + 1, i + 1)) %
                  mod
           << endl;
      return 0;
    }
}
