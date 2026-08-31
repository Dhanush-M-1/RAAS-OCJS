#include <bits/stdc++.h>
using namespace ::std;
const long double PI = acos(-1);
const long long MOD = 1000000000 + 7;
long long gcd(long long a, long long b) { return b == 0 ? a : gcd(b, a % b); }
long long add(long long a, long long b, long long m = MOD) {
  if (a >= m) a %= m;
  if (b >= m) b %= m;
  if (a < 0) a += m;
  if (b < 0) b += m;
  long long res = a + b;
  if (res >= m or res <= -m) res %= m;
  if (res < 0) res += m;
  return res;
}
long long mul(long long a, long long b, long long m = MOD) {
  if (a >= m) a %= m;
  if (b >= m) b %= m;
  if (a < 0) a += m;
  if (b < 0) b += m;
  long long res = a * b;
  if (res >= m or res <= -m) res %= m;
  if (res < 0) res += m;
  return res;
}
long long pow_mod(long long a, long long b, long long m = MOD) {
  long long res = 1LL;
  a = a % m;
  while (b) {
    if (b & 1) res = mul(res, a, m);
    b >>= 1;
    a = mul(a, a, m);
  }
  return res;
}
long long fastexp(long long a, long long b) {
  long long res = 1LL;
  while (b) {
    if (b & 1) res = res * a;
    b >>= 1;
    a *= a;
  }
  return res;
}
int gcdExtendido(int a, int b, int *x, int *y) {
  if (a == 0) {
    *x = 0;
    *y = 1;
    return b;
  }
  int x1, y1;
  int gcd = gcdExtendido(b % a, a, &x1, &y1);
  *x = y1 - (b / a) * x1;
  *y = x1;
  return gcd;
}
int modInverso(int a, int m) {
  int x, y;
  int g = gcdExtendido(a, m, &x, &y);
  if (g != 1)
    return -1;
  else
    return (x % m + m) % m;
}
const int N = 200000 + 5;
int n;
int q;
int k;
int a, b;
int ft[3][N];
void update(int id, int pos, int val) {
  pos++;
  while (pos <= n) {
    ft[id][pos] += val;
    pos += (-pos) & pos;
  }
}
int getSum(int id, int pos) {
  pos++;
  int ans = 0;
  while (pos > 0) {
    ans += ft[id][pos];
    pos &= pos - 1;
  }
  return ans;
}
int query(int id, int L, int R) {
  if (L > R) return 0;
  return getSum(id, R) - getSum(id, L - 1);
}
int main() {
  scanf("%d %d", &(n), &(k));
  scanf("%d %d", &(a), &(b));
  scanf("%d", &(q));
  int op;
  int x, y;
  while (q--) {
    scanf("%d", &(op));
    if (op == 1) {
      scanf("%d %d", &(x), &(y));
      x--;
      int take = query(0, x, x);
      update(0, x, max(0, min(y, b - take)));
      take = query(1, x, x);
      update(1, x, max(0, min(y, a - take)));
    } else {
      scanf("%d", &(x));
      x--;
      int ans = query(0, 0, x - 1) + query(1, x + k, n - 1);
      printf("%d\n", ans);
    }
  }
  return 0;
}
