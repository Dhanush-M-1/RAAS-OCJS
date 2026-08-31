#include <bits/stdc++.h>
using namespace std;
const int MOD = 1e9 + 7;
const int INF = 1e9 + 5;
const long long LINF = LLONG_MAX;
int main() {
  int n;
  cin >> n;
  int a[n];
  int r1 = 0, r2 = 0;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    if (a[i] <= 500000) {
      r1 = max(r1, a[i] - 1);
    }
    if (a[i] > 500000) {
      r2 = max(r2, 1000000 - a[i]);
    }
  }
  cout << max(r1, r2) << "\n";
}
