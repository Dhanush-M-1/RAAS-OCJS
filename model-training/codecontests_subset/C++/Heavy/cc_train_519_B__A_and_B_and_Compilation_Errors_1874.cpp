#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  vector<int> a(n);
  for (int i = 0; i < n; ++i) cin >> a[i];
  sort(a.begin(), a.end());
  vector<int> b(n - 1);
  for (int i = 0; i < n - 1; ++i) cin >> b[i];
  sort(b.begin(), b.end());
  bool f = false;
  for (int i = 0; i < n - 1; ++i) {
    if (b[i] != a[i]) {
      cout << a[i] << endl;
      a.erase(a.begin() + i);
      f = true;
      break;
    }
  }
  if (!f) {
    cout << a[n - 1] << endl;
    a.erase(a.begin() + n - 1);
  }
  vector<int> c(n - 2);
  for (int i = 0; i < n - 2; ++i) cin >> c[i];
  sort(c.begin(), c.end());
  f = false;
  for (int i = 0; i < n - 2; ++i) {
    if (c[i] != a[i]) {
      cout << a[i] << endl;
      f = true;
      break;
    }
  }
  if (!f) {
    cout << a[n - 2] << endl;
  }
  return 0;
}
