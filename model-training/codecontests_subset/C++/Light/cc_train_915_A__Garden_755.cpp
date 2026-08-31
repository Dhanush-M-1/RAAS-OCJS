#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k, i, ans = 0, j;
  int arr[101];
  cin >> n >> k;
  for (i = 0; i < n; i++) {
    cin >> j;
    if (k % j == 0) {
      if (j > ans) ans = j;
    }
  }
  cout << k / ans << endl;
  return 0;
}
