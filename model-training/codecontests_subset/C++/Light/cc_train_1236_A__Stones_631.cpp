#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int t;
  cin >> t;
  while (t--) {
    long long int a, b, c;
    cin >> a >> b >> c;
    long long int x = min(b, c / 2);
    long long int ans = 3 * x;
    long long int y = min((b - x) / 2, a);
    ans += 3 * y;
    cout << ans << "\n";
  }
}
