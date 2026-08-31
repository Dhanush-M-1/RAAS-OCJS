#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k, a[100], m = 0;
  cin >> n >> k;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  for (int o = 0; o < n; o++) {
    if (k % a[o] == 0) {
      m = max(m, a[o]);
    }
  }
  cout << k / m;
  return 0;
}
