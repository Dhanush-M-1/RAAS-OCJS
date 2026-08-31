#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  string s;
  cin >> s;
  int mx = -1;
  int x = 0, y = n + 1;
  for (int i = 0; i < n; i++) {
    if ((s[i] - 97) > mx) {
      x = i + 1;
      mx = s[i] - 97;
    } else if ((s[i] - 97) < mx) {
      y = i + 1;
      break;
    }
  }
  if (y == n + 1) {
    cout << "NO" << endl;
  } else {
    cout << "YES" << endl;
    cout << x << ' ' << y << ' ' << endl;
  }
}
