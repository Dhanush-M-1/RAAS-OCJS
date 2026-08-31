#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c, i;
  cin >> n >> c;
  int a, b;
  cin >> a;
  int maxdiff = 0, diff;
  for (i = 0; i < n - 1; ++i) {
    cin >> b;
    diff = a - b;
    if (diff > maxdiff) {
      maxdiff = diff;
    }
    a = b;
  }
  if (maxdiff - c > 0)
    cout << maxdiff - c << endl;
  else
    cout << 0 << endl;
  return 0;
}
