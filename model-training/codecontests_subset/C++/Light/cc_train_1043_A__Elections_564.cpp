#include <bits/stdc++.h>
using namespace std;
int main() {
  {
    long long int n;
    cin >> n;
    long long int a[n], i, j, k = INT_MIN, s = 0;
    for (i = 0; i < n; i++) {
      cin >> a[i];
      k = max(k, a[i]);
      s += a[i];
    }
    j = k;
    while (j > 0) {
      long long int p = j * n;
      long long int q = p - s;
      if (q > s) {
        break;
      }
      j++;
    }
    cout << j << endl;
  }
  return 0;
}
