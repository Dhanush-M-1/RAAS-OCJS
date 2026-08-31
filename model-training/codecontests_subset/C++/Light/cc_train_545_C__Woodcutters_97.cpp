#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  vector<pair<long long, long long>> tree(n);
  for (int i = 0; i < n; ++i) cin >> tree[i].first >> tree[i].second;
  int cuts = 1;
  for (int i = 1; i < n; ++i) {
    if (tree[i].first - tree[i].second > tree[i - 1].first)
      ++cuts;
    else {
      if (i == n - 1 || tree[i].first + tree[i].second < tree[i + 1].first) {
        tree[i].first += tree[i].second;
        ++cuts;
      }
    }
  }
  cout << cuts;
  return 0;
}
