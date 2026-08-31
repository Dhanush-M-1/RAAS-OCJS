#include <bits/stdc++.h>
using namespace std;
const double eps = 1e-9;
const int inf = 2000000000;
const long long int infLL = 9000000000000000000;
const int Mx = 1e3 + 123;
long long int n, x, y, k;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  cin >> n >> x >> y;
  k = (long long int)ceil((n * y) / 100.0);
  if (k > x)
    cout << k - x << endl;
  else
    cout << 0 << endl;
  return 0;
}
