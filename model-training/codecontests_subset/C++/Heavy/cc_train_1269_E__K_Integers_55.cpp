#include <bits/stdc++.h>
using namespace std;
const int maxn = 3e5 + 5;
const int INF = 0x3f3f3f3f;
const int mod = 1e9 + 7;
const double Pi = acos(-1);
long long gcd(long long a, long long b) { return b ? gcd(b, a % b) : a; }
long long lcm(long long a, long long b) { return a / gcd(a, b) * b; }
double dpow(double a, long long b) {
  double ans = 1.0;
  while (b) {
    if (b % 2) ans = ans * a;
    a = a * a;
    b /= 2;
  }
  return ans;
}
long long quick_pow(long long x, long long y) {
  long long ans = 1;
  while (y) {
    if (y & 1) {
      ans = ans * x % mod;
    }
    x = x * x % mod;
    y >>= 1;
  }
  return ans;
}
int n;
int a[maxn], c[maxn];
int lowbit(int x) { return x & (-x); }
long long bit1[maxn], bit2[maxn];
void add(long long *bit, int pos, int val) {
  while (pos < maxn) {
    bit[pos] += val;
    pos += lowbit(pos);
  }
}
long long query(long long *bit, int pos) {
  long long ans = 0;
  while (pos) {
    ans += bit[pos];
    pos -= lowbit(pos);
  }
  return ans;
}
int bs(long long *bit, int val) {
  int i = 0;
  for (int j = 19; j >= 0; j--) {
    if ((i | 1 << j) < maxn) {
      if (bit[i | 1 << j] <= val) {
        val -= bit[i |= 1 << j];
      }
    }
  }
  return i;
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
    c[a[i]] = i;
  }
  long long cnt = 0;
  for (int i = 1; i <= n; i++) {
    int p = c[i];
    add(bit1, p, 1);
    cnt += i - query(bit1, p);
    add(bit2, p, p);
    int pos = bs(bit1, i / 2) + 1;
    long long sum = 0;
    long long aa = i / 2, bb = i - i / 2 - 1;
    sum += (long long)aa * pos - (long long)aa * (aa + 1) / 2 -
           query(bit2, pos - 1);
    sum += (query(bit2, maxn) - query(bit2, pos)) - (long long)bb * pos -
           (long long)bb * (bb + 1) / 2;
    printf("%lld\n", sum + cnt);
  }
  return 0;
}
