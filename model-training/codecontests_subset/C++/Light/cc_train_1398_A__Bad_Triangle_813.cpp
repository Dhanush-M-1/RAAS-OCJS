#include <bits/stdc++.h>
using namespace std;
const double pi = acos(-1);
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  long long tc;
  cin >> tc;
  while (tc--) {
    long long n, x, a, b, y;
    cin >> y >> a >> b;
    n = y - 2;
    while (n--) cin >> x;
    if (a + b > x)
      cout << "-1\n";
    else
      cout << "1 2 " << y << endl;
  }
}
