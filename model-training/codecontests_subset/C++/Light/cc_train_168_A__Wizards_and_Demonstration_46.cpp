#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  cin >> n >> x >> y;
  y = ceil((y * n) / 100.0);
  cout << max(y - x, 0) << endl;
  ;
}
