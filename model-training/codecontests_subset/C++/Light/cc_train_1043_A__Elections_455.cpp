#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n, i, j, s = 0, s1 = 0, max = 0;
  cin >> n;
  long long int a[n], b[n];
  for (i = 0; i < n; i++) {
    cin >> a[i];
    s += a[i];
    if (a[i] > max) max = a[i];
  }
  long long int k = max;
  while (1) {
    s1 = 0;
    for (i = 0; i < n; i++) {
      b[i] = k - a[i];
      s1 += b[i];
    }
    if (s1 > s) {
      cout << k;
      break;
    }
    k++;
  }
}
