#include <bits/stdc++.h>
using namespace std;
vector<int> v;
int main() {
  int i, j, k, s, d, r, m, n, mx;
  cin >> n;
  s = 0;
  mx = 0;
  for (i = 1; i <= n; i++) {
    cin >> r;
    v.push_back(r);
    s += r;
    mx = max(r, mx);
  }
  for (i = mx; i <= 250; i++) {
    d = 0;
    for (j = 0; j < n; j++) {
      d += (i - v[j]);
    }
    if (d > s) break;
  }
  cout << i << endl;
  return 0;
}
