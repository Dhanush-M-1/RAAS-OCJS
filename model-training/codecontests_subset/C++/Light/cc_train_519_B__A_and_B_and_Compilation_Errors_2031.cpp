#include <bits/stdc++.h>
using namespace std;
const double EPS = 1e-9;
const double PI = acos(-1.0);
const int MOD = 1000 * 1000 * 1000 + 7;
const int INF = 2000 * 1000 * 1000;
template <typename T>
inline T sqr(T n) {
  return n * n;
}
int n, x;
long long a, b, c;
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    scanf("%d", &x);
    a += x;
  }
  for (int i = 0; i < n - 1; i++) {
    scanf("%d", &x);
    b += x;
  }
  for (int i = 0; i < n - 2; i++) {
    scanf("%d", &x);
    c += x;
  }
  printf("%I64d\n%I64d\n", a - b, b - c);
  return 0;
}
