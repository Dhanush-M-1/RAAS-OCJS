#include <bits/stdc++.h>
using namespace std;
const int maxx = 0x3f3f3f3f;
int main() {
  int n;
  cin >> n;
  vector<int> p(n);
  for (int i = 0; i < n; ++i) {
    int x;
    cin >> x;
    p[i] = x;
  }
  int ans = maxx;
  for (int i = 0; i < n + 1; ++i) {
    int cur = 0;
    if (i) cur = max(cur, p[i - 1] - 1);
    if (i != n) cur = max(cur, 1000000 - p[i]);
    ans = min(ans, cur);
  }
  cout << ans << endl;
  return 0;
}
