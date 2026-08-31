#include <bits/stdc++.h>
using namespace std;
long int a[102], m, n, c, i;
int main() {
  cin >> n >> c;
  for (i = 1; i <= n; i++) {
    cin >> a[i];
    if (i != 1 && a[i - 1] - a[i] - c > m) m = a[i - 1] - a[i] - c;
  }
  cout << m << endl;
  return 0;
}
