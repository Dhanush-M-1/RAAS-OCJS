#include <bits/stdc++.h>
using namespace std;
const int N = (int)1e3 + 4;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long int n, i, x, t = 1000000, l = 0;
  cin >> n;
  long long int a[n];
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  sort(a, a + n);
  x = 0;
  for (int i = 0; i < n; i++) {
    x = min(a[i] - 1, t - a[i]);
    l = max(l, x);
  }
  cout << l;
  return 0;
}
