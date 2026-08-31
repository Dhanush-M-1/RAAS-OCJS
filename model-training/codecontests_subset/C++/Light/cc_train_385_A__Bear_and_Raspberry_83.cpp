#include <bits/stdc++.h>
using namespace std;
const int size = 1007;
const long long modulo = 1000000007;
const long long INF = 1e9;
const double EPS = 1e-6;
char a[size][size];
int main() {
  int n, k;
  cin >> n >> k;
  vector<int> a(n);
  int ans = 0;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    if (i > 0) ans = max(ans, a[i - 1] - a[i] - k);
  }
  cout << ans << endl;
  return 0;
}
