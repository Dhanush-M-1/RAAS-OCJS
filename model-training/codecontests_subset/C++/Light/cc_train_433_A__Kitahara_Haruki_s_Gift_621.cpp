#include <bits/stdc++.h>
using namespace std;
long long max(long long a, long long b, long long c) {
  return (a > b) ? (a > c) ? a : c : (b > c) ? b : c;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int n;
  cin >> n;
  int a[n];
  int i, j, k;
  int actr = 0, bctr = 0;
  for (i = 0; i < n; i++) {
    cin >> a[i];
    if (a[i] == 100)
      actr++;
    else
      bctr++;
  }
  int z = actr + 2 * bctr;
  if (z % 2 != 0)
    cout << "NO\n";
  else {
    if (actr == 0) {
      if (bctr % 2 != 0)
        cout << "NO\n";
      else
        cout << "YES\n";
    } else if (bctr == 0) {
      if (actr % 2 == 0)
        cout << "YES\n";
      else
        cout << "NO\n";
    } else {
      cout << "YES\n";
    }
  }
  return 0;
}
