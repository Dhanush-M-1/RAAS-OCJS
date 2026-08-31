#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  cin >> n >> x >> y;
  int req_wiz = ceil((y / 100.0) * n);
  cout << (req_wiz - x >= 0 ? req_wiz - x : 0) << "\n";
  return 0;
}
