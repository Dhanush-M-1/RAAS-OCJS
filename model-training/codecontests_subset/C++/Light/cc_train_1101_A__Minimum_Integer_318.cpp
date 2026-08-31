#include <bits/stdc++.h>
using namespace std;
int main() {
  int q;
  cin >> q;
  long long a, b, c, s, m;
  while (q--) {
    cin >> a >> b >> c;
    long long x;
    if (c < a)
      x = c;
    else {
      x = ((b / c) + 1) * c;
    }
    cout << x << '\n';
  }
}
