#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, ans = 0;
  cin >> n;
  for (int i = int(0); i < int(n); ++i) {
    cin >> x;
    ans = max(ans, min(x - 1, 1000000 - x));
  }
  cout << ans << endl;
  return 0;
}
