#include <bits/stdc++.h>
using namespace std;
int Max = INT_MIN, Min = INT_MAX;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  ;
  int n, m, mx = 0;
  cin >> n >> m;
  int a[n];
  for (int i = 0; i < n; i++) cin >> a[i];
  for (int i = 0; i < n - 1; i++) {
    if ((a[i] - a[i + 1] - m) > mx) {
      mx = (a[i] - a[i + 1] - m);
    }
  }
  cout << ((mx > 0) ? mx : 0);
  return 0;
}
