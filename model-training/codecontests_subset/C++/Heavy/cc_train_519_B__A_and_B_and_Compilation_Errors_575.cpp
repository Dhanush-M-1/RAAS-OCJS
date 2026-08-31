#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, val;
  cin >> n;
  vector<int> a, b, c;
  for (i = 0; i < n; i++) {
    cin >> val;
    a.push_back(val);
  }
  for (i = 0; i < n - 1; i++) {
    cin >> val;
    b.push_back(val);
  }
  for (i = 0; i < n - 2; i++) {
    cin >> val;
    c.push_back(val);
  }
  sort(a.begin(), a.end());
  sort(b.begin(), b.end());
  for (i = 0; i <= n - 1; i++) {
    if (a[i] != b[i]) {
      printf("%d\n", a[i]);
      c.push_back(a[i]);
      break;
    }
    if (i == n - 1) {
      printf("%d\n", a[i]);
      c.push_back(a[i]);
      break;
    }
  }
  sort(c.begin(), c.end());
  for (i = 0; i <= n - 1; i++) {
    if (a[i] != c[i]) {
      printf("%d\n", a[i]);
      break;
    }
    if (i == n - 1) {
      printf("%d\n", a[i]);
    }
  }
}
