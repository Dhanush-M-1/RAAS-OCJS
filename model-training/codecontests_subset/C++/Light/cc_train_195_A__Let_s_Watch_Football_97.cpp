#include <bits/stdc++.h>
using namespace std;
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long int a, b, c;
  cin >> a >> b >> c;
  if (a * c % b == 0)
    cout << (a * c) / b - c << endl;
  else
    cout << ((a * c) / b - c + 1) << endl;
  return 0;
}
