#include <bits/stdc++.h>
using namespace std;
int main() {
  cin.tie(0);
  cout.tie(0);
  ios_base::sync_with_stdio(0);
  int n, val, mx = -1, L = 1e6;
  cin >> n;
  while (n--) {
    cin >> val;
    mx = max(min(val - 1, L - val), mx);
  }
  cout << mx << "\n";
  return 0;
}
