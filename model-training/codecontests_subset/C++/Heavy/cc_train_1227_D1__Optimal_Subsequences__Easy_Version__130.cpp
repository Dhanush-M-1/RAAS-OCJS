#include <bits/stdc++.h>
using namespace std;
using ll = long long;
const int N = 100;
int arr[N];
multimap<int, int, greater<int>> l;
map<int, int> mp;
vector<int> ans[N];
int main() {
  ios_base::sync_with_stdio();
  cin.tie(0);
  cout.tie(0);
  int n;
  scanf("%d", &n);
  for (int i = 0; i < n; ++i) scanf("%d", arr + i);
  int m;
  scanf("%d", &m);
  for (int i = 0; i < n; ++i) {
    l.insert(make_pair(arr[i], i));
  }
  for (int i = 0; i < n; ++i) {
    map<int, int> temp;
    int j = 0;
    for (auto t = l.begin(); j <= i; ++j, ++t) {
      temp[t->second] = t->first;
    }
    for (auto t : temp) {
      ans[i].emplace_back(t.second);
    }
  }
  for (int i = 0; i < m; ++i) {
    int k, pos;
    scanf("%d%d", &k, &pos);
    --k, --pos;
    printf("%d\n", ans[k][pos]);
  }
}
