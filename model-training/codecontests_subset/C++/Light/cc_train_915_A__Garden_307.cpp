#include <bits/stdc++.h>
using namespace std;
const double PI = acos(-1.0);
int main() {
  int n, k, a[111], i, mi = 11111111;
  cin >> n >> k;
  for (i = 1; i <= n; i++) cin >> a[i];
  for (i = 1; i <= n; i++)
    if (k % a[i] == 0) {
      mi = min(k / a[i], mi);
    }
  cout << mi << endl;
  return 0;
}
