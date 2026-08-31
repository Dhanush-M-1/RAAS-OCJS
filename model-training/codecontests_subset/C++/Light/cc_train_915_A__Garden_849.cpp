#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k;
  cin >> n >> k;
  int Array[n + 5];
  for (int i = 0; i < n; i++) cin >> Array[i];
  sort(Array, Array + n);
  int ans = 1;
  for (int i = n - 1; i >= 0; i--) {
    if (k % Array[i] == 0) {
      ans = Array[i];
      break;
    }
  }
  ans = k / ans;
  cout << ans << endl;
  return 0;
}
