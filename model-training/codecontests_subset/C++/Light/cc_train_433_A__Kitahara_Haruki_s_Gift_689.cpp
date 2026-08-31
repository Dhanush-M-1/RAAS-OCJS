#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c1 = 0, c2 = 0, a;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a;
    if (a == 100)
      c1++;
    else
      c2++;
  }
  if ((c2 * 2 + c1) % 2 != 0)
    cout << "NO\n";
  else {
    if (c2 % 2 == 0) {
      cout << "YES\n";
    } else {
      if (c1 < 2) {
        cout << "NO\n";
      } else
        cout << "YES\n";
    }
  }
  return 0;
}
