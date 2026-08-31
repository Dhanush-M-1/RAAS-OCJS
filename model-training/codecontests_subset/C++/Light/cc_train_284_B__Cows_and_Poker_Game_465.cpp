#include <bits/stdc++.h>
#pragma GCC optimize("O3")
#pragma GCC target("sse4")
using namespace std;
const long double pi = acos(-1);
const long long maxn = 2e5 + 5;
const int mod = 1e9 + 7;
const long long INF = 1e18;
const int MX = 2000000001;
int main() {
  ios_base::sync_with_stdio(0), cin.tie(0);
  long long t, q, n, a, b, c, d, k, l, m, r, x = 0, y = 0, z = 0, sum = 0,
                                             ans = 0, temp = 0, res = 0;
  string second;
  cin >> n >> second;
  a = b = c = 0;
  for (auto x : second) {
    a += (x == 'A');
    b += (x == 'I');
    c += (x == 'F');
  }
  cout << (b > 1 ? 0 : (b == 1 ? 1 : a));
}
