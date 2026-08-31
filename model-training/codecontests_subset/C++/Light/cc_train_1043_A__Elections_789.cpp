#include <bits/stdc++.h>
using namespace std;
int main() {
  long n, max, a[200], k, i, sume, suma;
  cin >> n;
  for (i = 0; i < n; i++) cin >> a[i];
  max = a[0];
  sume = 0;
  for (i = 0; i < n; i++) {
    sume += a[i];
    if (a[i] > max) max = a[i];
  }
  k = max;
  while (1) {
    suma = 0;
    for (i = 0; i < n; i++) suma += (k - a[i]);
    if (suma > sume) break;
    k++;
  }
  cout << k << endl;
  return 0;
}
