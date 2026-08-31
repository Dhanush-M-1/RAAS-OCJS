#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  vector<pair<int, int> > v;
  for (int i = 0; i < n; ++i) {
    int x, h;
    cin >> x >> h;
    v.push_back(make_pair(x, h));
  }
  int res = min(2, n);
  for (int i = 1; i < n - 1; ++i) {
    if (v[i - 1].first < (v[i].first - v[i].second)) {
      res++;
    } else if (v[i].first + v[i].second < v[i + 1].first) {
      v[i].first += v[i].second;
      res++;
    }
  }
  cout << res << "\n";
  return 0;
}
