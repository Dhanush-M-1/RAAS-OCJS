#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  string x[1001], y[1001];
  string a, b, s;
  cin >> a >> b;
  x[0] = a;
  y[0] = b;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> a >> b;
    if (a == x[i - 1])
      x[i] = b, y[i] = y[i - 1];
    else if (a == y[i - 1])
      x[i] = x[i - 1], y[i] = b;
  }
  for (int i = 0; i <= n; i++) cout << x[i] << " " << y[i] << endl;
  return 0;
}
