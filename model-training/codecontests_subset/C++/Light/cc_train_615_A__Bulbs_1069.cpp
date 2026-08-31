#include <bits/stdc++.h>
using namespace std;
long long n, m, bulb, i, j, sum;
bool a[105] = {false};
int main() {
  cin >> n >> m;
  for (i = 1; i <= n; i++) {
    cin >> sum;
    while (sum--) {
      cin >> bulb;
      a[bulb] = true;
    }
  }
  for (i = 1; i <= m; i++) {
    if (a[i] == false) {
      cout << "NO" << endl;
      return 0;
    }
  }
  cout << "YES" << endl;
  return 0;
}
