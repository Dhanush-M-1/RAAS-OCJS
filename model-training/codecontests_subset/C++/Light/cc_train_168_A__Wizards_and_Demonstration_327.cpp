#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0), cout.tie(0);
  int n, x, y;
  cin >> n >> x >> y;
  int need = ceil(n * (y / 100.00));
  cout << max(need - x, 0) << endl;
  return 0;
}
