#include <bits/stdc++.h>
using namespace std;
long long Z = 1e9 + 7;
int main() {
  long long t;
  cin >> t;
  while (t--) {
    long long a, b, c;
    cin >> a >> b >> c;
    long long ans = 0;
    {
      ans += (min((c / 2), b) * 3);
      b = b - c / 2;
    }
    if (b > 0) {
      ans += min(a, b / 2) * 3;
    }
    cout << ans << endl;
  }
}
