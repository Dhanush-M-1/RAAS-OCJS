#include <bits/stdc++.h>
using namespace std;
const int sz = 100010;
vector<int> v;
int main() {
  int a, c, n, t;
  cin >> n >> c;
  t = n;
  while (t--) {
    cin >> a;
    v.push_back(a);
  }
  int res = 0;
  for (int i = 0; i < n - 1; ++i) {
    int diff = (v[i] - v[i + 1] - c);
    res = max(res, diff);
  }
  cout << res;
  return 0;
}
