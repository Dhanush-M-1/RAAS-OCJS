#include <bits/stdc++.h>
using namespace std;
int n, x, ans1, ans2;
int main() {
  ios::sync_with_stdio();
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> x;
    if (x <= 500000) {
      ans1 = max((x - 1), ans1);
    } else {
      ans2 = max((1000000 - x), ans2);
    }
  }
  cout << max(ans1, ans2);
  return 0;
}
