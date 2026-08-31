#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, ans = 0;
  int r = 1000000;
  cin >> n;
  for (int i = 0; i < n; i++) {
    int pos;
    cin >> pos;
    ans = max(ans, min(pos - 1, r - pos));
  }
  cout << ans << endl;
  return 0;
}
