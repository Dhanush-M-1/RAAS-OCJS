#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c, min1 = -9999, b;
  cin >> n >> c;
  int a[n + 1];
  for (int i = 0; i < n; i++) cin >> a[i];
  for (int i = 0; i < n - 1; i++) {
    b = a[i] - c - a[i + 1];
    if (b < 0)
      continue;
    else {
      min1 = max(min1, b);
    }
  }
  if (min1 == -9999)
    cout << 0 << endl;
  else
    cout << min1 << endl;
  return 0;
}
