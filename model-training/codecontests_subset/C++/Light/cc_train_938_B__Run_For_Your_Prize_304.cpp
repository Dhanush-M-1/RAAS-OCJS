#include <bits/stdc++.h>
using namespace std;
int main() {
  int i = 1;
  int y = 1000000;
  int n, j, arr;
  cin >> n;
  int ans = 0;
  while (n--) {
    cin >> arr;
    ans = max(ans, min(arr - i, y - arr));
  }
  cout << ans << endl;
  return 0;
}
