#include <bits/stdc++.h>
using namespace std;
int main() {
  int d[3] = {};
  int n;
  cin >> n;
  int x;
  for (int i = 0; i < n; i++) {
    cin >> x;
    d[x / 100]++;
  }
  if ((d[1] % 2 == 0 && d[2] % 2 == 0) || (2 * d[2] == d[1] && d[1] % 2 == 0) ||
      (d[2] % 2 != 0 && d[1] % 2 == 0 && d[1] != 0))
    cout << "YES";
  else
    cout << "NO";
  return 0;
}
