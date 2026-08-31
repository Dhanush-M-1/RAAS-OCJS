#include <bits/stdc++.h>
using namespace std;
ifstream fin("input.in");
ofstream fout("output.out");
int main() {
  int n, d, ans = 0, inc = 0;
  cin >> n >> d;
  vector<long long> v(n + 1);
  vector<long long> maxInc(n + 1);
  for (int i = 1; i <= n; ++i) {
    int x;
    cin >> x;
    v[i] = v[i - 1] + x;
    if (d < v[i]) {
      cout << -1;
      return 0;
    }
  }
  for (int i = n; i > 0; --i) {
    if (i < n) {
      maxInc[i] = min(maxInc[i + 1], d - v[i]);
    } else {
      maxInc[i] = d - v[i];
    }
  }
  for (int j = 1; j <= n; ++j) {
    if (d < v[j] + inc) {
      cout << -1;
      return 0;
    }
    if (v[j] == v[j - 1] && v[j] + inc < 0) {
      ans++, inc = maxInc[j];
      if (v[j] + inc < 0) {
        cout << -1;
        return 0;
      }
    }
  }
  cout << ans;
  return 0;
}
