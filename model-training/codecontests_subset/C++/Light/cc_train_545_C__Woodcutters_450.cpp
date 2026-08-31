#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  vector<pair<long long, long long>> coll(n);
  for (int i = 0; i < n; i++) cin >> coll[i].first >> coll[i].second;
  long long ans = 0;
  for (int i = 0; i < n; i++) {
    if (i == 0)
      ans++;
    else if (i == n - 1)
      ans++;
    else if (coll[i].first - coll[i].second > coll[i - 1].first)
      ans++;
    else if (coll[i].first + coll[i].second < coll[i + 1].first) {
      ans++;
      coll[i].first += coll[i].second;
    }
  }
  cout << ans << endl;
  return 0;
}
