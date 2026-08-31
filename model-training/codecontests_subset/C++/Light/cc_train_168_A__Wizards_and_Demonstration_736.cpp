#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  double n, x, y;
  cin >> n >> x >> y;
  double ad = ceil(n * y / 100.0);
  if (ad > x)
    cout << ad - x;
  else {
    cout << "0";
  }
  return 0;
}
