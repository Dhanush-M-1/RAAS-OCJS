#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 10;
int main() {
  int n, mx = 0;
  cin >> n;
  vector<int> a(n);
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    mx = max(mx, a[i]);
  }
  for (int i = mx; i <= 300; i++) {
    int s = 0;
    for (int j = 0; j < n; j++) {
      s += i - a[j];
      s -= a[j];
    }
    if (s > 0) {
      cout << i << endl;
      return 0;
    }
  }
  return 0;
}
