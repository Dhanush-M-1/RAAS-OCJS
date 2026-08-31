#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(NULL);
  cout.tie(NULL);
  int t, n, i;
  cin >> t;
  while (t--) {
    cin >> n;
    int ar[n];
    for (i = 0; i < n; i++) cin >> ar[i];
    if (ar[0] + ar[1] <= ar[n - 1])
      cout << 1 << ' ' << 2 << ' ' << n << '\n';
    else
      cout << -1 << '\n';
  }
}
