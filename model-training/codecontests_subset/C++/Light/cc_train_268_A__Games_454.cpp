#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int ans = 0;
  vector<pair<int, int> > v(n);
  for (int i = 0; i < n; i++) cin >> v[i].first >> v[i].second;
  for (int i = 0; i < n; i++)
    for (int j = 0; j < n; j++)
      if (v[i].first == v[j].second) ans++;
  cout << ans;
  return 0;
}
