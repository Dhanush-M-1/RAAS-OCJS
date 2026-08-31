#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout << fixed;
  cout << setprecision(9);
  long long int m, p = 2e9, k = 0, l, q, r, j = 0, t, n, i;
  for (i = 0; i < 5; i++) {
    cin >> n;
    k += n;
  }
  if (k % 5 == 0 && k > 0)
    cout << k / 5;
  else
    cout << -1;
  return 0;
}
