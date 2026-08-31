#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n, k, y;
  cin >> n >> k >> y;
  long double tmp = ceil(n * (y / 100.00));
  if ((int)tmp - k <= 0)
    cout << 0;
  else
    cout << (int)tmp - k;
}
