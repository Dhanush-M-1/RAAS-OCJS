#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int i, j, k, n, m, p, t;
  cin >> n;
  long long int x[100001];
  long long int h[100001];
  for (i = 0; i < n; i++) {
    cin >> x[i] >> h[i];
  }
  if (n < 3) {
    cout << n << endl;
    return 0;
  }
  p = 2;
  for (i = 1; i < (n - 1); i++) {
    if ((x[i] - h[i]) > x[i - 1]) {
      p++;
    } else if ((x[i] + h[i]) < x[i + 1]) {
      p++;
      x[i] = x[i] + h[i];
    }
  }
  cout << p << endl;
  return 0;
}
