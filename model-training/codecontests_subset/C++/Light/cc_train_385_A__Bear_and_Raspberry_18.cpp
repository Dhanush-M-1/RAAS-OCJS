#include <bits/stdc++.h>
using namespace std;
const double EPS = 1E-9;
int main() {
  int n, c, a[1000], res = -10000000 + 13;
  cin >> n >> c;
  for (int i = 0; i < n; i++) cin >> a[i];
  for (int i = 0; i < n - 1; i++) {
    int tmp = a[i] - c - a[i + 1];
    if (tmp > res) res = tmp;
    if (res < 0) res = 0;
  }
  cout << res;
  return 0;
}
