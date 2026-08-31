#include <bits/stdc++.h>
using namespace std;
void solve() {
  int n, x, y;
  cin >> n >> x >> y;
  if (x > ((n * y) / 100)) {
    cout << "0";
  } else {
    if ((n * y) % 100 == 0) {
      cout << ((n * y) / 100) - x;
    } else {
      cout << ((n * y) / 100) - x + 1;
    }
  }
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  solve();
  cerr << "Time : " << (double)clock() / (double)CLOCKS_PER_SEC << "s\n";
  return 0;
}
