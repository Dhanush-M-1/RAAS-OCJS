#include <bits/stdc++.h>
using namespace std;
int N;
int main() {
  cin >> N;
  vector<pair<long long, long long> > tree;
  for (int i = 0; i < N; i++) {
    long long x, h;
    cin >> x >> h;
    tree.push_back(make_pair(x, h));
  }
  int ans = min(2, N);
  for (int i = 1; i < N - 1; i++) {
    if (tree[i - 1].first + tree[i].second < tree[i].first) {
      ans++;
    } else if (tree[i].first + tree[i].second < tree[i + 1].first) {
      ans++;
      tree[i].first += tree[i].second;
    }
  }
  cout << ans << "\n";
  return 0;
}
