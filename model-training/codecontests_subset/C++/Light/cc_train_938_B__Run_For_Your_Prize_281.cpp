#include <bits/stdc++.h>
using namespace std;
const long long inf = (long long)1e9 + 1;
const int N = (int)1e5 + 77;
const long long mod = (long long)1e9 + 7;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n, a[N], k = (int)1e6;
  cin >> n;
  for (int i = 0; i < (int)(n); ++i) cin >> a[i];
  int m = min(k - a[0], a[n - 1] - 1);
  for (int i = 0; i < (int)(n - 1); ++i) {
    m = min(m, max(a[i] - 1, k - a[i + 1]));
  }
  cout << m << endl;
  return 0;
}
