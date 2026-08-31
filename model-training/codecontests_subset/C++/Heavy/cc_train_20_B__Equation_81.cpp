#include <bits/stdc++.h>
using namespace std;
const int Z = (int)1e5 + 111;
const int inf = (int)1e9 + 111;
const long long llinf = (long long)1e18 + 5;
int main() {
  ios_base::sync_with_stdio(false);
  long double a, b, c;
  cin >> a >> b >> c;
  if (a == 0 && b == 0 && c == 0) {
    cout << -1;
    return 0;
  }
  if (a == 0 && b == 0 && c != 0) {
    cout << 0;
    return 0;
  }
  if (a == 0) {
    cout << "1\n";
    long double h = -c / b;
    cout.precision(15);
    cout << h;
    return 0;
  }
  long double d = b * b - 4 * a * c;
  if (d < 0) {
    cout << 0;
    return 0;
  }
  if (d == 0) {
    cout << "1\n";
    d = -b / (2 * a);
    cout.precision(15);
    cout << d;
  } else {
    cout << "2\n";
    vector<long double> ans;
    ans.push_back((-b - sqrt(d)) / (2 * a));
    cout.precision(15);
    ans.push_back((-b + sqrt(d)) / (2 * a));
    sort((ans).begin(), (ans).end());
    cout << ans[0] << '\n';
    cout << ans[1];
  }
  return 0;
}
