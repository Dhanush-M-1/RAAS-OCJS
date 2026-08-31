#include <bits/stdc++.h>
using namespace std;
int main() {
  long int a, b, c, d, e, i, j, k, l, n, m;
  cin >> n;
  for (i = 0; i < n; i++) {
    cin >> a >> b >> c;
    if (c < a)
      cout << c << endl;
    else
      cout << ((b / c) + 1) * c << endl;
  }
}
