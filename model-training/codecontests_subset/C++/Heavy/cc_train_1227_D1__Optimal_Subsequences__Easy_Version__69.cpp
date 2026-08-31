#include <bits/stdc++.h>
using namespace std;
hash<string> hfn;
const int inf = 2e9;
const long long mod = 1e9 + 7;
const long double eps = 1e-8;
const long long biginf = 2e18;
bool comp(pair<int, int> a, pair<int, int> b) {
  if (a.first == b.first) return a.second > b.second;
  return a.first < b.first;
}
void solve() {
  int n;
  cin >> n;
  vector<pair<int, int> > v(n);
  vector<int> stv(n);
  for (int i = 0; i < n; i++) {
    cin >> v[i].first;
    v[i].second = i;
    stv[i] = v[i].first;
  }
  sort((v).begin(), (v).end(), comp);
  int q;
  cin >> q;
  for (int i = 0; i < q; i++) {
    int k, ind;
    cin >> k >> ind;
    ind--;
    int pos = n - k + ind;
    vector<pair<int, int> > r;
    for (int i = n - k; i < n; i++)
      r.push_back(make_pair(v[i].second, v[i].first));
    sort((r).begin(), (r).end());
    cout << r[ind].second << endl;
  }
}
void multisolve() {
  int t;
  cin >> t;
  while (t--) solve();
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  solve();
}
