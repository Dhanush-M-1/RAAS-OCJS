#include <bits/stdc++.h>
using namespace std;
long long int a[100005];
int main() {
  int t, a, b, c, x, y;
  cin >> t;
  while (t--) {
    cin >> a >> b >> c;
    y = min(c / 2, b);
    b -= y;
    x = min(b / 2, a);
    cout << 3 * x + 3 * y << '\n';
  }
}
