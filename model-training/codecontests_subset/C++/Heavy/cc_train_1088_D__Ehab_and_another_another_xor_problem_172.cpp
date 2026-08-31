#include <bits/stdc++.h>
using namespace std;
int question(int c, int d) {
  int ans;
  cout << "? " << c << " " << d << endl;
  fflush(stdout);
  cin >> ans;
  return ans;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  int f, s, a = 0, b = 0;
  int big = question(0, 0);
  for (int i = 29; i >= 0; --i) {
    f = question(a | (1 << i), b);
    s = question(a, b | (1 << i));
    if (f == s) {
      if (big == 1)
        a |= (1 << i);
      else
        b |= (1 << i);
      big = f;
    } else {
      if (f == -1) {
        a |= (1 << i);
        b |= (1 << i);
      }
    }
  }
  cout << "! " << a << " " << b << endl;
  return 0;
}
