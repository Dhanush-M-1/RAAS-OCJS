#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, ar[101], sum = 0, opp = 0, ans = 0, mx = 0;
  cin >> n;
  for (int i = 0; i < n; i++) cin >> ar[i], sum += ar[i], mx = max(mx, ar[i]);
  for (int i = 1; i <= 10001; i++) {
    opp = 0;
    for (int j = 0; j < n; j++) {
      int x = max(0, (i - ar[j]));
      opp += x;
    }
    if (opp > sum) {
      ans = i;
      break;
    }
  }
  cout << max(ans, mx) << endl;
  return 0;
}
