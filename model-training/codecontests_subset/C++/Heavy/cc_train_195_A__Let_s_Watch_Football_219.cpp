#include <bits/stdc++.h>
using namespace std;
void adskiy_razgon() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
}
const int mxN = 1e+9 + 7;
const long long INF = 1e+18 + 7;
long long nod(long long a, long long b) {
  if (b > a) {
    swap(a, b);
  }
  while (b > 0) {
    a %= b;
    swap(a, b);
  }
  return a;
}
long long nok(long long a, long long b) { return a * b / nod(a, b); }
void sp(long long a, double b) { cout << fixed << setprecision(a) << b; }
long long binpow(long long a, long long n) {
  if (n == 0) {
    return 1;
  }
  if (n % 2 == 1) {
    return binpow(a, n - 1) * a;
  } else {
    long long b = binpow(a, n / 2);
    return b * b;
  }
}
void solve() {
  int n, m, t;
  cin >> n >> m >> t;
  cout << ((n - m) * t + m - 1) / m;
}
int main() {
  adskiy_razgon();
  long long t = 1;
  for (int i = 1; i <= t; ++i) {
    solve();
  }
  return 0;
}
