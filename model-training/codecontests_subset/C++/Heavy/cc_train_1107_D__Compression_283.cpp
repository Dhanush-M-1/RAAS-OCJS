#include <bits/stdc++.h>
using namespace std;
template <class T>
inline T bigMod(T p, T e, T M) {
  T ret = 1;
  for (; e > 0; e >>= 1) {
    if (e & 1) ret = (ret * p) % M;
    p = (p * p) % M;
  }
  return (T)ret;
}
template <class T>
inline T modInverse(T a, T M) {
  return bigMod(a, M - 2, M);
}
template <class T>
inline T gcd(T a, T b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
template <class T>
inline T lcm(T a, T b) {
  a = abs(a);
  b = abs(b);
  return (a / gcd(a, b)) * b;
}
template <class T>
inline string int2String(T a) {
  ostringstream str;
  str << a;
  return str.str();
}
const int dr[] = {0, 1, 0, -1, -1, 1, 1, -1, -2, -2, 2, 2, -1, -1, 1, 1};
const int dc[] = {1, 0, -1, 0, 1, 1, -1, -1, -1, 1, -1, 1, -2, 2, -2, 2};
void fileIO() {}
int H2I(char c) {
  if ('A' <= c && c <= 'F')
    return 10 + c - 'A';
  else
    return c - '0';
}
int n, a[5300][5300];
bool ok(int x) {
  int area = x * x;
  for (int i = x; i <= n; i += x) {
    for (int j = x; j <= n; j += x) {
      int sum = a[i][j] + a[i - x][j - x] - a[i][j - x] - a[i - x][j];
      if (sum && sum != area) return 0;
    }
  }
  return 1;
}
char ch[11111];
int main() {
  fileIO();
  int start_s = clock();
  scanf("%d", &n);
  int x;
  for (int i = int(0); i < int(n); i++) {
    scanf("%s", ch);
    for (int j = int(0); j < int((n >> 2)); j++) {
      x = H2I(ch[j]);
      for (int k = (j + 1) * 4, p = 0; k > j * 4; k--, p++)
        a[i + 1][k] = ((bool)(x & (1 << (p))));
    }
  }
  for (int i = int(1); i < int(n + 1); i++)
    for (int j = int(2); j < int(n + 1); j++) a[i][j] += a[i][j - 1];
  for (int j = int(1); j < int(n + 1); j++)
    for (int i = int(2); i < int(n + 1); i++) a[i][j] += a[i - 1][j];
  int mx = 1;
  for (int x = sqrt(n); x >= 1; x--) {
    if (n % x == 0) {
      if (ok(x)) (mx = max(mx, x));
      if (ok(n / x)) (mx = max(mx, n / x));
    }
  }
  printf("%d\n", mx);
  return 0;
}
