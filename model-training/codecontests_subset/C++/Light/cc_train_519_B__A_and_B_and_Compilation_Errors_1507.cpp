#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  vector<int> a(n), b(n - 1), c(n - 2);
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  sort(a.begin(), a.end());
  for (int i = 0; i < n - 1; i++) {
    cin >> b[i];
  }
  sort(b.begin(), b.end());
  for (int i = 0; i < n - 2; i++) {
    cin >> c[i];
  }
  sort(c.begin(), c.end());
  int u = 0;
  while (u < n - 1 && a[u] == b[u]) {
    u++;
  }
  cout << a[u] << endl;
  u = 0;
  while (u < n - 2 && b[u] == c[u]) {
    u++;
  }
  cout << b[u];
}
