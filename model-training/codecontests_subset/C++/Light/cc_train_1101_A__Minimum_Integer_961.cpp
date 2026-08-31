#include <bits/stdc++.h>
using namespace std;
long long int modd = 1e9 + 7;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int t, l, r, d;
  cin >> t;
  int x;
  while (t--) {
    cin >> l >> r >> d;
    if (d < l)
      x = d;
    else
      x = d * ((r / d) + 1);
    cout << x << endl;
  }
  return 0;
}
