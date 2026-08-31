#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, j = 0;
  cin >> n;
  long long int a[n], b[n - 1], c[n - 2], d = 0, e = 0, f = 0;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    d += a[i];
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> b[i];
    e += b[i];
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> c[i];
    f += c[i];
  }
  cout << d - e << endl;
  cout << e - f << endl;
}
