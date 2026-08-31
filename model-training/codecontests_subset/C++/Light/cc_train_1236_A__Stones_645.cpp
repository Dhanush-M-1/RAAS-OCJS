#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  while (n--) {
    int a, b, c, ans = 0;
    cin >> a >> b >> c;
    ans += min(c / 2, b) * 3;
    b -= min(c / 2, b);
    ans += min(a, b / 2) * 3;
    cout << ans << endl;
  }
}
