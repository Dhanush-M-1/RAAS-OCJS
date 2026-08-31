#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, ans = 1;
  cin >> n;
  pair<long long, long long> t[n];
  for (int i = 0; i < n; i++) cin >> t[i].first >> t[i].second;
  for (int i = 1; i < n - 1; i++) {
    if (t[i].first - t[i].second > t[i - 1].first)
      ans++;
    else if (t[i].first + t[i].second < t[i + 1].first)
      t[i].first += t[i].second, ans++;
  }
  if (n != 1) ans++;
  cout << ans;
}
