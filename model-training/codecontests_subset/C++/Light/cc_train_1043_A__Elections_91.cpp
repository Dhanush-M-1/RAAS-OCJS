#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  int n;
  cin >> n;
  vector<int> v(n);
  int mx = 0;
  for (auto& it : v) {
    cin >> it;
    mx = max(mx, it);
  }
  for (int i = mx;; i++) {
    int tot = 0, temp = 0;
    for (int j = 0; j < n; j++) {
      tot += v[j];
      temp += i - v[j];
    }
    if (temp > tot) {
      cout << i << "\n";
      break;
    }
  }
  return 0;
}
