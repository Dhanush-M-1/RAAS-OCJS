#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, i, f;
  cin >> n;
  long long x[n], h[n];
  for (i = 0; i < n; i++) cin >> x[i] >> h[i];
  if (n == 1)
    f = 1;
  else if (n == 2)
    f = 2;
  else {
    f = 2;
    for (i = 1; i < n - 1; i++) {
      if ((x[i] - h[i]) > x[i - 1])
        f++;
      else if ((x[i] + h[i]) < x[i + 1]) {
        f++;
        x[i] = x[i] + h[i];
      } else
        continue;
    }
  }
  cout << f;
}
