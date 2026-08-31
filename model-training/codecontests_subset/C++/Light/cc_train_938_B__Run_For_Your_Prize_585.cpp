#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int ans, ne;
  ans = ne = 0;
  for (int i = 0; i < n; i++) {
    int t;
    cin >> t;
    ne = min(t - 1, 1000000 - t);
    ans = max(ans, ne);
  }
  cout << ans << endl;
  return 0;
}
