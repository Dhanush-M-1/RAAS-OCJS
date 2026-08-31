#include <bits/stdc++.h>
using namespace std;
const double PI = 3.1415926535897932;
const long long INF = 1e18;
long long gcd(long long x, long long y) { return (y == 0 ? x : gcd(y, x % y)); }
int main() {
  vector<long long> x;
  vector<long long> h;
  int n, i, r, nb = 1;
  cin >> n;
  for (long long i = 0; i < (long long)n; i++) {
    cin >> r;
    x.push_back(r);
    cin >> r;
    h.push_back(r);
  }
  x.push_back(INF);
  for (long long i = 1; i < (long long)n; i++) {
    if (x[i] - x[i - 1] > h[i])
      nb++;
    else if (x[i + 1] - x[i] > h[i]) {
      nb++;
      x[i] += h[i];
    }
  }
  cout << nb;
  return 0;
}
