#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a[100004], b[100004], c[100004], i, p = 0, j;
  long long suma = 0, sumb = 0, sumc = 0;
  cin >> n;
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
  cout << suma - sumb << endl << sumb - sumc << endl;
  return 0;
}
