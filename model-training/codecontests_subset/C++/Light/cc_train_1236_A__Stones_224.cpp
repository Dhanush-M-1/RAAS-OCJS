#include <bits/stdc++.h>
using namespace std;
int n, a, b, c;
int main() {
  cin >> n;
  while (n--) {
    cin >> a >> b >> c;
    int ans = 0;
    for (int i = 0; i <= a && i * 2 <= b; i++) {
      ans = max(ans, i * 3 + min((b - i * 2) * 3, (c / 2) * 3));
    }
    cout << ans << endl;
  }
}
