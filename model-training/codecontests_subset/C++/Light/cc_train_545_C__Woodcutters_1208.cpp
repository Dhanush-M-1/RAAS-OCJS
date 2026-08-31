#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, j, c = 2;
  cin >> n;
  int64_t X1, X2, x[n + 5], h[n + 5], S;
  for (i = 0; i < n; i++) {
    cin >> x[i] >> h[i];
  }
  X1 = x[0], X2 = x[n - 1];
  if (n < 2) cout << n << endl, exit(0);
  for (i = 1; i < n - 1; i++) {
    if (x[i] - h[i] > X1)
      c++;
    else if (x[i + 1] - x[i] > h[i])
      x[i] += h[i], c++;
    X1 = x[i];
  }
  cout << c << endl;
}
