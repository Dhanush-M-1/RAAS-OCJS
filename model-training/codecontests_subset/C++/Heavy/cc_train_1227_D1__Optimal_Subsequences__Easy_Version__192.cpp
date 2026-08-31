#include <bits/stdc++.h>
using namespace std;
const int MAXN = 2e6 + 1;
const int INF = 2e9 + 1;
const int MOD = (1e9 + 7);
void bye(string s = "") {
  cout << s << '\n';
  exit(0);
}
signed main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int n;
  cin >> n;
  vector<int> arr(n);
  set<pair<int, int> > kek;
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
    kek.emplace(-arr[i], i);
  }
  int m;
  cin >> m;
  for (int i = 0; i < m; i++) {
    int k, pos;
    cin >> k >> pos;
    auto e = kek.begin();
    vector<pair<int, int> > mem;
    for (int i = 0; i < k; i++) {
      mem.emplace_back(e->second, e->first);
      e++;
    }
    sort((mem).begin(), (mem).end());
    cout << mem[pos - 1].second * -1 << '\n';
  }
  bye();
}
