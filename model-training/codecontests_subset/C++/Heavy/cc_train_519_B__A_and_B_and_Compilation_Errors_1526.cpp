#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, k, mx = -1;
  vector<int> a, b, c;
  cin >> n;
  for (i = 0; i < n; i++) {
    cin >> k;
    a.push_back(k);
  }
  sort(a.begin(), a.end());
  for (i = 0; i < n - 1; i++) {
    cin >> k;
    b.push_back(k);
  }
  sort(b.begin(), b.end());
  for (i = 0; i < n - 1; i++) {
    if (b[i] != a[i]) {
      cout << a[i] << endl;
      mx = 1;
      break;
    }
  }
  if (mx == -1) cout << a[n - 1] << endl;
  for (i = 0; i < n - 2; i++) {
    cin >> k;
    c.push_back(k);
  }
  mx = -1;
  sort(c.begin(), c.end());
  for (i = 0; i < n - 2; i++) {
    if (c[i] != b[i]) {
      cout << b[i] << endl;
      mx = 1;
      break;
    }
  }
  if (mx == -1) cout << b[n - 2] << endl;
  return 0;
}
