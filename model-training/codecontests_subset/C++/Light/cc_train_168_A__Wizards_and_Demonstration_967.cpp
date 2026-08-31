#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  double i, j, k;
  cin >> i >> j >> k;
  double ans = ceil((k * i) / 100);
  if (j >= ans)
    cout << 0;
  else
    cout << ans - j;
  return 0;
}
