#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  int T;
  cin >> T;
  while (T--) {
    int a, b, c;
    cin >> a >> b >> c;
    int res = 0;
    int q = min(b, c / 2);
    res += (q + q * 2);
    q = min(a, (b - q) / 2);
    res += (q + q * 2);
    cout << res << endl;
  }
  return 0;
}
