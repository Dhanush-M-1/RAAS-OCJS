#include <bits/stdc++.h>
using namespace std;
const int MX = 200020;
const int N = 1000060;
const int mod = (int)1e9 + 7;
int bc[1111][1111];
int main() {
  cin.tie(0);
  cin.sync_with_stdio(0);
  int n, k;
  cin >> n >> k;
  int a[n];
  for (int i = 0; i < n; ++i) {
    cin >> a[i];
  }
  sort(a, a + n);
  for (int i = n - 1; i >= 0; --i) {
    if (k % a[i] == 0) {
      cout << k / a[i] << endl;
      return 0;
    }
  }
  return 0;
}
