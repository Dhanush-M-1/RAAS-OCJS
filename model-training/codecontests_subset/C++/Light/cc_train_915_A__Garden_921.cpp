#include <bits/stdc++.h>
using namespace std;
const long long mod = 1e9 + 7;
int main() {
  int n, k;
  cin >> n >> k;
  int a[n + 1];
  for (int i = 0; i < n; i++) cin >> a[i];
  int min1 = 1000;
  for (int i = 0; i < n; i++) {
    if (k % a[i] == 0) {
      min1 = min(min1, k / a[i]);
    }
  }
  cout << min1 << endl;
}
