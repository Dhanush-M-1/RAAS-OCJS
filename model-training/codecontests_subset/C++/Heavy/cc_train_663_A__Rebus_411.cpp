#include <bits/stdc++.h>
using namespace std;
int main() {
  char c, a[105];
  int x = 0, p = 1, n = 0, k;
  while (c != '=') {
    cin >> c;
    if (c == '+') {
      a[x++] = c;
      p++;
    } else if (c == '-') {
      a[x++] = c;
      n++;
    }
  }
  cin >> k;
  if (k > k * p - n || k < p - n * k)
    cout << "Impossible" << endl;
  else {
    cout << "Possible" << endl;
    int S = 0;
    for (int i = 0; i < x; i++) {
      int sign = 1;
      if (i > 0 && a[i - 1] == '-') sign = -1;
      if (sign == 1) p--;
      if (sign == -1) n--;
      for (int j = 1; j <= k; j++) {
        if (S + j * sign + p - n * k <= k && S + j * sign + p * k - n >= k) {
          cout << j << " " << a[i] << " ";
          S = S + j * sign;
          break;
        }
      }
    }
    cout << abs(k - S) << " "
         << "="
         << " " << k << endl;
  }
  return 0;
}
