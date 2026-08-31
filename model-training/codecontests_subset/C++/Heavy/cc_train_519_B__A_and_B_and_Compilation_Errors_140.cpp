#include <bits/stdc++.h>
using namespace std;
const int MAX = 1000 * 100 + 100;
string s;
int ans[3][MAX];
int n, a;
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a;
    ans[0][i] = a;
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> a;
    ans[1][i] = a;
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> a;
    ans[2][i] = a;
  }
  sort(ans[0], ans[0] + n);
  sort(ans[1], ans[1] + n - 1);
  sort(ans[2], ans[2] + n - 2);
  for (int i = 0; i < n; i++) {
    if (ans[0][i] < ans[1][i]) {
      cout << ans[0][i] << endl;
      break;
    }
    if (i == n - 1) cout << ans[0][i] << endl;
  }
  for (int i = 0; i < n - 1; i++) {
    if (ans[1][i] < ans[2][i]) {
      cout << ans[1][i] << endl;
      break;
    }
    if (i == n - 2) cout << ans[1][n - 2] << endl;
  }
  return 0;
}
