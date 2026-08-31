#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k;
  cin >> n >> k;
  vector<pair<int, pair<int, int>>> v;
  for (int i = 0; i < n; i++) {
    int t, a, b;
    cin >> t >> a >> b;
    v.push_back({t, {a, b}});
  }
  vector<int> f;
  vector<pair<int, pair<int, int>>> l;
  vector<pair<int, pair<int, int>>> r;
  for (auto xx : v) {
    if ((xx.second.second == 1) && (xx.second.first == 1)) {
      f.push_back(xx.first);
    }
    if ((xx.second.second == 0) && (xx.second.first == 1)) {
      l.push_back(xx);
    }
    if ((xx.second.second == 1) && (xx.second.first == 0)) {
      r.push_back(xx);
    }
  }
  sort(l.begin(), l.end());
  sort(r.begin(), r.end());
  int id1 = 0, id2 = 0;
  while ((id1 < l.size()) && (id2 < r.size())) {
    f.push_back(l[id1].first + r[id2].first);
    id1++, id2++;
  }
  sort(f.begin(), f.end());
  long long sum = 0;
  if (f.size() < k) {
    cout << "-1"
         << "\n";
    return 0;
  }
  for (int i = 0; i < k; i++) {
    sum += f[i];
  }
  cout << sum << "\n";
}
