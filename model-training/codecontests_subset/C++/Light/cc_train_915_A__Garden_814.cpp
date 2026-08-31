#include <bits/stdc++.h>
using namespace std;
int t, n, k;
int main() {
  ios_base::sync_with_stdio(false), cin.tie(0);
  t = 1;
  while (t--) {
    cin >> n >> k;
    vector<int> arr(n);
    int mini = 10000000, val;
    double d;
    for (int i = (1); i < (n + 1); i++) {
      cin >> val;
      d = k / (val * 1.0);
      if (d - floor(k / (val * 1.0)) == 0) {
        mini = min(k / val, mini);
      }
    }
    cout << mini << '\n';
  }
  return 0;
}
