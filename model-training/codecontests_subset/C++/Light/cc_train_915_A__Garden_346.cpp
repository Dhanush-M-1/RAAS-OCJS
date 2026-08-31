#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k, a;
  cin >> n >> k;
  int ans = 1000;
  for (int i = 0; i < n; i++) {
    cin >> a;
    if (k % a == 0 && k / a < ans) {
      ans = k / a;
    }
  }
  cout << ans;
}
