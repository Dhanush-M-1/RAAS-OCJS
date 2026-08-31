#include <bits/stdc++.h>
using namespace std;
int mod = 1000000007;
int gcd(int a, int b) { return b ? gcd(b, a % b) : a; }
int lcm(int a, int b) { return a * b / gcd(a, b); }
long long bpow(long long a, long long b, long long m) {
  a %= m;
  long long res = 1;
  while (b > 0) {
    if (b & 1) res = res * a % m;
    a = a * a % m;
    b >>= 1;
  }
  return res;
}
void go() {}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(NULL);
  std::cout.tie(NULL);
  int n, x, y;
  cin >> n >> x >> y;
  double temp = (x * 100) / n;
  if (temp >= y)
    cout << "0";
  else {
    if ((n * y) % 100 == 0)
      cout << ((n * y) / 100) - x;
    else
      cout << ((n * y) / 100) - x + 1;
  }
  return 0;
}
