#include <bits/stdc++.h>
using namespace std;
const int INF = 1e9 + 1;
const int N = 1e6 * 3;
const double EPS = 1 / 1e10;
vector<int> v, v1;
set<pair<long long, long long> > second;
bool cmp(pair<long long, long long> a, pair<long long, long long> b) {
  return (a.first > b.first) || (a.first == b.first && a.second < b.second);
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int q, n;
  cin >> n;
  pair<long long, long long> a[n];
  for (int i = 0; i < n; ++i) {
    cin >> a[i].first;
    a[i].second = i;
  }
  sort(a, a + n, cmp);
  cin >> q;
  for (int w = 1; w <= q; w++) {
    int k, pos;
    second.clear();
    cin >> k >> pos;
    for (int i = 0; i < k; i++)
      second.insert(make_pair(a[i].second, a[i].first));
    set<pair<long long, long long> >::iterator it = second.begin();
    for (int i = 0; i < pos - 1; it++, i++)
      ;
    cout << it->second << "\n";
  }
  return 0;
}
