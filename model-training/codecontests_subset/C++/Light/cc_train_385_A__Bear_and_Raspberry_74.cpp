#include <bits/stdc++.h>
using namespace std;
long long a[1111];
long long res;
int main() {
  int n, c;
  cin >> n >> c;
  for (int i = 0; i < n; i++) cin >> a[i];
  for (int i = 0; i < n - 1; i++) {
    res = max(a[i] - a[i + 1] - c, res);
  }
  cout << res;
  return 0;
}
