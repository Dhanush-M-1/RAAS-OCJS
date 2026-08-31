#include <bits/stdc++.h>
int ATTENTION() {
http:
  return 0;
}
using namespace std;
const int iinf = 0x7fffffff;
const long long linf = ~(1LL << 63);
template <typename T>
inline T gcd(T a, T b) {
  if (a < 0) return gcd(-a, b);
  if (b < 0) return gcd(a, -b);
  if (a < b) return gcd(b, a);
  if (b == 0) return a;
  return gcd(b, a % b);
}
long long qpow(long long a, long long n, long long mod) {
  a %= mod;
  long long ans = 1LL;
  while (n) {
    if (n & 1) ans = (ans * a % mod);
    a = (a * a % mod);
    n >>= 1;
  }
  return ans;
}
inline long long rev(long long a, long long p) { return qpow(a, p - 2, p); }
template <typename T>
inline void BPS(T* DST, T* SRC, int N, int s = 0) {
  DST[s] = SRC[s];
  for (int i = 1; i < N; i++) DST[s + i] = DST[s + i - 1] + SRC[s + i];
}
inline int in() {
  int x;
  cin >> x;
  return x;
}
inline void tic() {}
inline void toc() {}
const int maxn = 1;
int ask(long long c, long long d) {
  cout << "? " << c << " " << d << endl;
  int resp = -2;
  cin >> resp;
  if (resp == -2) exit(0);
  return resp;
}
void output(long long a, long long b) { cout << "! " << a << " " << b << endl; }
int a[33], b[33];
void set_bit(long long& x, int pos, int val) {
  if (val == 0) {
    x = (~(1LL << pos)) & x;
  } else {
    x = x | (1LL << pos);
  }
}
void solve() {
  long long mask_a = 0, mask_b = 0;
  int last_cmp = ask(mask_a, mask_b);
  for (int i = 29; i >= 0; i--) {
    if (last_cmp == -1) {
      set_bit(mask_a, i, 1);
      set_bit(mask_b, i, 1);
      int tmp = ask(mask_a, mask_b);
      if (tmp == 1) {
        a[i] = 0;
        b[i] = 1;
        set_bit(mask_a, i, 0);
        set_bit(mask_b, i, 1);
        last_cmp = ask(mask_a, mask_b);
      } else {
        set_bit(mask_a, i, 0);
        set_bit(mask_b, i, 1);
        tmp = ask(mask_a, mask_b);
        if (tmp < 0) {
          a[i] = b[i] = 0;
        } else {
          a[i] = b[i] = 1;
        }
        set_bit(mask_a, i, 0);
        set_bit(mask_b, i, 0);
      }
    } else if (last_cmp == 1) {
      set_bit(mask_a, i, 1);
      set_bit(mask_b, i, 1);
      int tmp = ask(mask_a, mask_b);
      if (tmp == -1) {
        a[i] = 1;
        b[i] = 0;
        set_bit(mask_a, i, 1);
        set_bit(mask_b, i, 0);
        last_cmp = ask(mask_a, mask_b);
      } else {
        set_bit(mask_a, i, 0);
        set_bit(mask_b, i, 1);
        tmp = ask(mask_a, mask_b);
        if (tmp < 0) {
          a[i] = b[i] = 0;
        } else {
          a[i] = b[i] = 1;
        }
        set_bit(mask_a, i, 0);
        set_bit(mask_b, i, 0);
      }
    } else if (last_cmp == 0) {
      set_bit(mask_a, i, 0);
      set_bit(mask_b, i, 1);
      int tmp = ask(mask_a, mask_b);
      if (tmp < 0) {
        a[i] = b[i] = 0;
      } else {
        a[i] = b[i] = 1;
      }
      set_bit(mask_a, i, 0);
      set_bit(mask_b, i, 0);
    }
  }
}
int main() {
  ios::sync_with_stdio(0);
  solve();
  long long ra = 0, rb = 0;
  for (int i = 0; i < 30; i++) {
    ra |= ((long long)a[i] << i);
    rb |= ((long long)b[i] << i);
  }
  output(ra, rb);
  return 0;
}
