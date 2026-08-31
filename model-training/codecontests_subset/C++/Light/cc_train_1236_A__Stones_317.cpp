#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int a, b, c;
    cin >> a >> b >> c;
    int ans = 0;
    int minx = min(b, c / 2);
    ans += minx * 3;
    b -= minx;
    minx = min(a, b / 2);
    ans += minx * 3;
    cout << ans << endl;
  }
}
