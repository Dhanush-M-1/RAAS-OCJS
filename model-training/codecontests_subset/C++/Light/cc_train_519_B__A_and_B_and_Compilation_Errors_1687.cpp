#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, x;
  cin >> n;
  vector<int> a, b, c;
  for (i = 0; i < n; i++) {
    cin >> x;
    a.push_back(x);
  }
  sort(a.begin(), a.end());
  for (i = 1; i < n; i++) {
    cin >> x;
    b.push_back(x);
  }
  sort(b.begin(), b.end());
  for (i = 0; i < n - 1; i++) {
    if (a[i] != b[i]) break;
  }
  cout << a[i] << endl;
  for (i = 2; i < n; i++) {
    cin >> x;
    c.push_back(x);
  }
  sort(c.begin(), c.end());
  for (i = 0; i < n - 2; i++) {
    if (b[i] != c[i]) break;
  }
  cout << b[i];
  return 0;
}
