#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int t;
  cin >> t;
  while (t--) {
    int a, b, c;
    cin >> a >> b >> c;
    int stones = 0;
    int auxc = c;
    int auxb = b;
    if (c >= 2 && b) {
      stones += 3 * min(auxb, auxc / 2);
      c -= 2 * min(auxc / 2, auxb);
      b -= min(auxc / 2, auxb);
    }
    if (a && b >= 2) {
      stones += 3 * min(a, b / 2);
      a -= min(b / 2, a);
    }
    cout << stones << '\n';
  }
}
