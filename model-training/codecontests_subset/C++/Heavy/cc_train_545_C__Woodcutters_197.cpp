#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long int n;
  cin >> n;
  vector<pair<long long int, long long int>> v;
  for (long long int i = 0; i < n; i++) {
    long long int x, y;
    cin >> x >> y;
    v.push_back(make_pair(x, y));
  }
  if (n >= 3) {
    long long int ans = 2;
    long long int var = 0;
    for (long long int i = n - 2; i > 0; i--) {
      long long int lr = v[i + 1].first - v[i].first - 1 - var;
      long long int ur = v[i].first - v[i - 1].first - 1;
      if (lr >= v[i].second) {
        ans++;
        var = 0;
      } else if (ur >= v[i].second) {
        ans++;
        var = v[i].second;
      } else
        var = 0;
    }
    cout << ans << "\n";
  } else
    cout << n << "\n";
}
