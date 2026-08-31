#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  double a, b, c;
  cin >> a >> b >> c;
  long int ans = ceil(((a - b) * c) / b);
  cout << ans << '\n';
  return 0;
}
