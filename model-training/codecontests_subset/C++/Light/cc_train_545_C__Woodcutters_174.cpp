#include <bits/stdc++.h>
using namespace std;
using lld = long long int;
int main() {
  lld n;
  cin >> n;
  vector<pair<lld, lld> > V(n);
  for (int i = 0; i < n; i++) {
    lld x, y;
    cin >> x >> y;
    V[i] = {x, y};
  }
  if (n == 1) {
    cout << 1 << endl;
    return 0;
  }
  lld ans = 2;
  for (int i = 1; i < n - 1; i++) {
    if (V[i].first - V[i].second > V[i - 1].first) {
      ans++;
    } else if (V[i + 1].first > V[i].first + V[i].second) {
      ans++;
      V[i].first = V[i].first + V[i].second;
    } else {
      continue;
    }
  }
  cout << ans << endl;
  return 0;
}
