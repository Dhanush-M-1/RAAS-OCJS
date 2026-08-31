#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  vector<long long int> a(n), b(n), c(n);
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> b[i];
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> c[i];
  }
  sort(a.begin(), a.end());
  sort(b.begin(), b.end());
  sort(c.begin(), c.end());
  int k1, k2;
  for (int i = 0; i < n; i++) {
    if (a[i] != b[i]) k1 = a[i];
    if (b[i] != c[i]) k2 = b[i];
  }
  cout << k1 << endl << k2;
  return 0;
}
