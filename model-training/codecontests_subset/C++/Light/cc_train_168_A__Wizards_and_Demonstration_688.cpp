#include <bits/stdc++.h>
const long long MOD7 = 1000000007;
int calc(int n, int x, int y) {
  int rp = ceil(y / 100.0 * n);
  return x >= rp ? 0 : rp - x;
}
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  int n, x, y;
  cin >> n >> x >> y;
  cout << calc(n, x, y) << "\n";
  return 0;
}
