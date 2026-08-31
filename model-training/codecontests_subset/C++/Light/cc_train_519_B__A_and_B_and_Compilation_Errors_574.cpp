#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, i, e1 = -1, e2 = -1, flag = 0, suma = 0, sumb = 0, sumc = 0;
  cin >> n;
  vector<long long> a(n), b(n - 1), c(n - 2);
  for (i = 0; i < n; i++) {
    cin >> a[i];
    suma += a[i];
  }
  for (i = 0; i < n - 1; i++) {
    cin >> b[i];
    sumb += b[i];
  }
  for (i = 0; i < n - 2; i++) {
    cin >> c[i];
    sumc += c[i];
  }
  cout << suma - sumb << endl << sumb - sumc;
  return 0;
}
