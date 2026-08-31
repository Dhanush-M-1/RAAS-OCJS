#include <bits/stdc++.h>
using namespace std;
int a[5206][5206], sum[5206][5206], v[5000];
int n, sol, lg;
int main() {
  cin >> n;
  for (int l = 1; l <= n; l++) {
    string s;
    cin >> s;
    for (int c = 1; c <= s.size(); c++) {
      char chr;
      int val;
      chr = s[c - 1];
      if (chr >= '0' and chr <= '9')
        val = chr - '0';
      else
        val = chr - 'A' + 10;
      for (int bit = 3; bit >= 0; bit--)
        a[l][4 * c - bit] = ((val & (1 << bit)) > 0);
    }
  }
  sol = n;
  for (int l = 1; l <= n; l++)
    for (int c = 1; c <= n; c++) {
      sum[l][c] = sum[l - 1][c] + sum[l][c - 1] - sum[l - 1][c - 1] + a[l][c];
    }
  for (int i = n; i >= 1; i--)
    if (n % i == 0) {
      lg++;
      v[lg] = i;
    }
  for (int k = 1; k <= lg; k++) {
    int dim = v[k];
    bool ok = true;
    for (int l = 0; l < n; l = l + dim)
      for (int c = 0; c < n; c = c + dim) {
        int sumtot = sum[l + dim][c + dim] - sum[l + dim][c] - sum[l][c + dim] +
                     sum[l][c];
        if (sumtot != 0 and sumtot != dim * dim) ok = false;
      }
    if (ok) {
      cout << dim;
      return 0;
    }
  }
  return 0;
}
