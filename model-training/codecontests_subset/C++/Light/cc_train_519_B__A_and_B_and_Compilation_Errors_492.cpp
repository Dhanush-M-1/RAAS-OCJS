#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, a;
  cin >> n;
  long long int d = 0, e = 0, f = 0;
  for (i = 0; i < n; i++) {
    cin >> a;
    d += a;
  }
  for (i = 0; i < n - 1; i++) {
    cin >> a;
    e += a;
  }
  for (i = 0; i < n - 2; i++) {
    cin >> a;
    f += a;
  }
  cout << d - e << endl << e - f;
  return 0;
}
