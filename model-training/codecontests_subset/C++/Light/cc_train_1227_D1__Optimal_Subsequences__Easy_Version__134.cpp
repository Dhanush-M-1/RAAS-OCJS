#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n, m, x, i, ma = 0;
  cin >> n;
  vector<pair<long long int, long long int>> v1;
  for (i = 1; i <= n; i++) cin >> x, v1.push_back(make_pair(-x, i));
  sort(v1.begin(), v1.end());
  cin >> m;
  while (m--) {
    long long int k, pos, j = 0;
    cin >> k >> pos;
    vector<pair<long long int, long long int>> v;
    while (j < k) {
      v.push_back(make_pair(v1[j].second, -v1[j].first));
      j++;
    }
    sort(v.begin(), v.end());
    cout << v[pos - 1].second << endl;
  }
  return 0;
}
