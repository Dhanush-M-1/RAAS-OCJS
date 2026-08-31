#include <bits/stdc++.h>
using namespace std;
int a[100001], b[100001], c[100001];
int main() {
  int n, i, j = 0, suma = 0, sumb = 0, sumc = 0;
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
  for (i = 0; i < n; i++) {
    if (sumb + a[i] == suma) {
      cout << a[i] << endl;
      break;
    }
  }
  for (i = 0; i < n - 1; i++) {
    if (sumc + b[i] == sumb) {
      cout << b[i] << endl;
      break;
    }
  }
}
