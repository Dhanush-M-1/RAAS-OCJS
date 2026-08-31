#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int n, s = 0, ma = 0;
  cin >> n;
  for (int i = 0; i < n; ++i) {
    int inp;
    cin >> inp;
    s += inp;
    ma = max(ma, inp);
  }
  cout << max(ma, (2 * s + n) / n) << endl;
  return 0;
}
