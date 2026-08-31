#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int T;
  cin >> T;
  while (T--) {
    int n, i, j, k;
    cin >> n;
    int a[n];
    vector<pair<int, int>> v;
    for (i = 0; i < n; i++) {
      cin >> a[i];
      v.push_back({a[i], i});
    }
    sort(v.begin(), v.end());
    if (v[0].first + v[1].first <= v[v.size() - 1].first ||
        v[0].first + v[v.size() - 1].first <= v[1].first ||
        v[v.size() - 1].first + v[1].first <= v[1].first) {
      cout << 1 << " " << 2 << " " << v.size() << endl;
    } else
      cout << -1 << endl;
  }
}
