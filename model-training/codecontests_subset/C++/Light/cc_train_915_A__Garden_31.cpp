#include <bits/stdc++.h>
using namespace std;
int n, k, a[101], m;
int main() {
  m = 101;
  cin >> n >> k;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    if (k % a[i] == 0) m = min(m, k / a[i]);
  }
  cout << m;
  return 0;
}
