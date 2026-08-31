#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, b, c, s = 0;
  cin >> n >> a >> b >> c;
  bool f = 0;
  for (int i = 0; i < c + 1; i++) {
    for (int j = 0; j < b + 1; j++) {
      if (n - 2 * i - j >= 0 && n - 2 * i - j <= a / 2) {
        s += 1;
        f = 1;
      }
    }
  }
  if (f == 0) {
    cout << 0 << "\n";
  } else {
    cout << s << "\n";
  }
  return 0;
}
