#include <bits/stdc++.h>
using namespace std;
int on_bit(int x, int pos) {
  x |= (1 << pos);
  return x;
}
int off_bit(int x, int pos) {
  x &= ~(1 << pos);
  return x;
}
bool is_on_bit(int x, int pos) { return ((x & (1 << pos)) != 0); }
int flip_bit(int x, int pos) {
  x ^= (1 << pos);
  return x;
}
int lsb(int x) { return x & (-x); }
int on_bit_all(int x, int pos) {
  x = (1 << pos) - 1;
  return x;
}
const double EPS = 1e-9;
const double PI = 2 * acos(0.0);
const int INF = 0x3f3f3f3f;
const int MOD = 1e9 + 7;
int add(long long a, long long b) { return ((a % MOD) + (b % MOD)) % MOD; }
int sub(long long a, long long b) { return ((a % MOD) - (b % MOD)) % MOD; }
int mult(long long a, long long b) { return ((a % MOD) * (b % MOD)) % MOD; }
long long gcd(long long a, long long b) { return b ? gcd(b, a % b) : a; }
int main() {
  int n, y, x;
  scanf("%d%d%d", &n, &y, &x);
  int required = (n * x) / 100 + ((n * x) % 100 != 0);
  printf("%d\n", max(required - y, 0));
  return 0;
}
