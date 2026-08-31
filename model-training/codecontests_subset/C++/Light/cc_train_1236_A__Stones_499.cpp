#include <bits/stdc++.h>
using namespace std;
int a, b, c;
int main() {
  int T;
  cin >> T;
  while (T--) {
    cin >> a >> b >> c;
    int ans = 0;
    int x = min(c / 2, b);
    ans += x * 3;
    b -= x;
    x = min(b / 2, a);
    ans += x * 3;
    cout << ans << endl;
  }
}
