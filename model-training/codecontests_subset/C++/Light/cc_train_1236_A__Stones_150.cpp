#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int t;
  cin >> t;
  while (t--) {
    long long int a, b, c, ans = 0;
    cin >> a >> b >> c;
    long long int te = min(b, c / 2);
    ans += 3 * te;
    b -= te;
    te = min(a, b / 2);
    ans += 3 * te;
    cout << ans << "\n";
  }
  return 0;
}
