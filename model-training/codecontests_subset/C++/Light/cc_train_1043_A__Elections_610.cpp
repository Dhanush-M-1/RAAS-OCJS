#include <bits/stdc++.h>
using namespace std;
const int INF = 1e9 + 7, N = 1e5 + 7, MOD = 998244353, M = 202;
int n, m;
long long inp[N];
int S;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> n;
  for (int i = 0; i < n; ++i) {
    cin >> inp[i];
    S += inp[i];
    m = max((long long)m, inp[i]);
  }
  for (int k = m; k < 10000; ++k) {
    if (n * k > 2 * S) {
      cout << k;
      return 0;
    }
  }
  return 0;
}
