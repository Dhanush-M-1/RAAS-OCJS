#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long int n, i, c, m = 0;
  cin >> n >> c;
  long long int a[n];
  cin >> a[0];
  for (i = 1; i < n; i++) {
    cin >> a[i];
    if (a[i - 1] - a[i] - c > 0) m = max(m, a[i - 1] - a[i] - c);
  }
  cout << m;
  return 0;
}
