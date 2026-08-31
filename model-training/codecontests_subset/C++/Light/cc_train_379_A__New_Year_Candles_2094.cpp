#include <bits/stdc++.h>
using namespace std;
int const GRAY = -2;
int const BLACK = -1;
int const WHITE = 0;
int const INF = 1e8;
long long const INF64 = 1e18;
template <typename T>
void alert(const T& t) {
  cout << t;
  exit(0);
}
int ugcd(int a, int b) { return b ? ugcd(b, a % b) : a; }
int gcd(int a, int b) { return ugcd(a, b) * ((a < 0) ^ (b < 0) ? -1 : +1); }
int lcm(int a, int b) { return abs(a * b) / gcd(a, b); }
int main(int argc, char* argv[]) {
  int a, b;
  cin >> a >> b;
  int ans = a;
  int c = a;
  while (c >= b) {
    ans += c / b;
    c = c % b + c / b;
  }
  cout << ans;
  return 0;
}
