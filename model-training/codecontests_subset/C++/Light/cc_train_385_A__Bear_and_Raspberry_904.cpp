#include <bits/stdc++.h>
using namespace std;
long long sum, d, z, mn = 1000000000, mx = -1000000000, ans, k, pos, l = 1, x,
                     y, r = 1, n, m, xc, yc;
map<int, int> mp;
bool ok;
int main() {
  cin >> n >> x;
  int a[n];
  for (int i = 0; i < n; ++i) cin >> a[i];
  for (int i = 1; i < n; ++i) {
    if (a[i] - x < a[i - 1]) {
      if (a[i - 1] - a[i] - x > r - l) r = a[i - 1], l = a[i] + x;
    }
  }
  cout << r - l;
}
