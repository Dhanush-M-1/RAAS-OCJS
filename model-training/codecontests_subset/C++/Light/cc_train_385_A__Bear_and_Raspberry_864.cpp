#include <bits/stdc++.h>
using namespace std;
int main() {
  int a[1001], b, c, d[501], maxn = 0;
  cin >> b >> c;
  for (int i = 1; i <= b; i++) {
    cin >> a[i];
  }
  for (int i = 1; i <= b - 1; i++) {
    d[i] = a[i] - a[i + 1];
    if (d[i] > maxn) {
      maxn = d[i];
    }
  }
  if (maxn > 0 && maxn - c > 0) {
    cout << maxn - c << endl;
  } else
    cout << 0 << endl;
}
