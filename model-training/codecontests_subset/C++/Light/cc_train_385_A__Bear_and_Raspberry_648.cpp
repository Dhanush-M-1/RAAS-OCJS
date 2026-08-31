#include <bits/stdc++.h>
using namespace std;
bool primes[10000001];
int main() {
  ios_base::sync_with_stdio(0), cin.tie(0);
  int n, c, x;
  cin >> n >> c;
  cin >> x;
  int maxdiff = 0, y;
  for (int i = 1; i < n; i++) {
    cin >> y;
    maxdiff = max(maxdiff, x - y);
    x = y;
  }
  if (maxdiff <= c)
    cout << 0 << endl;
  else
    cout << maxdiff - c << endl;
  return 0;
}
