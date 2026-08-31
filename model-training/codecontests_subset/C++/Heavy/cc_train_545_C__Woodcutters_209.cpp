#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int t;
  t = 1;
  while (t--) {
    long long int n;
    cin >> n;
    pair<long long int, long long int> a[n];
    for (int i = 0; i < n; i++) {
      long long int x, y;
      cin >> x >> y;
      a[i] = {x, y};
    }
    if (n == 1 || n == 2) {
      cout << n << endl;
      return 0;
    }
    long long int ans = 2;
    for (int i = 1; i < n - 1; i++) {
      if ((a[i].first - a[i].second) > a[i - 1].first) {
        ans++;
      } else if ((a[i].first + a[i].second) < a[i + 1].first) {
        ans++;
        a[i].first = a[i].first + a[i].second;
      }
    }
    cout << ans << endl;
  }
  return 0;
}
