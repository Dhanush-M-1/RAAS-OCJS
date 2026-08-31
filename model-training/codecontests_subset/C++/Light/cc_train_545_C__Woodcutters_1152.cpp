#include <bits/stdc++.h>
#pragma GCC optimize("O2")
using namespace std;
int main() {
  int n, co = 1;
  std::vector<pair<long long, long long>> v;
  cin >> n;
  for (int i = 0; i < n; i++) {
    long long a, b;
    cin >> a >> b;
    v.push_back(make_pair(a, b));
  }
  for (int i = 1; i < n; i++) {
    if (v[i].first - v[i].second > v[i - 1].first) {
      co++;
    } else if (v[i].first + v[i].second < v[i + 1].first) {
      v[i].first = v[i].first + v[i].second;
      co++;
    } else if (i == n - 1) {
      co++;
    }
  }
  cout << co;
  return 0;
}
