#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  double a, b, c;
  cin >> a >> b >> c;
  if (a == 0 && b == 0 && c == 0) {
    cout << -1;
    return 0;
  } else if (a == 0 && b == 0) {
    cout << 0;
    return 0;
  }
  if (a == 0) {
    cout << 1 << endl;
    cout << fixed << setprecision(10) << -c / b << endl;
    return 0;
  }
  double x = b * b - 4 * a * c;
  if (x < 0) {
    cout << 0;
    return 0;
  }
  vector<double> ans;
  ans.push_back((-b + sqrt(x)) / (2 * a));
  ans.push_back((-b - sqrt(x)) / (2 * a));
  cout << fixed << setprecision(10);
  sort(ans.begin(), ans.end());
  if (ans[0] != ans[1]) {
    cout << 2 << endl;
    cout << ans[0] << endl << ans[1];
  } else {
    cout << 1 << endl;
    cout << ans[0];
  }
  return 0;
}
