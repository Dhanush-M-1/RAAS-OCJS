#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  int t;
  cin >> t;
  while (t--) {
    int a, b, c;
    cin >> a >> b >> c;
    int t = 0, r1 = min(b, c / 2);
    b -= r1;
    c -= 2 * r1;
    t = 3 * r1;
    t += 3 * (min(a, b / 2));
    cout << t << "\n";
  }
}
