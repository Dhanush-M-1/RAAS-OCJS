#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long int n, m, i, j;
  cin >> n >> m;
  vector<long long int> v;
  for (i = 0; i < n; i++) {
    long long int y;
    cin >> y;
    v.push_back(y);
  }
  vector<set<long long int> > vv(n + 1);
  for (i = 0; i < m; i++) {
    long long int u, w;
    cin >> u >> w;
    vv[u].insert(w);
  }
  long long int last = n - 1;
  for (i = n - 2; i >= 0; i--) {
    if (vv[v[i]].find(v[last]) == vv[v[i]].end()) continue;
    long long int xx = v[i];
    for (j = i; j < last; j++) {
      if (vv[v[j]].find(v[j + 1]) != vv[v[j]].end()) {
        swap(v[j], v[j + 1]);
      } else
        break;
    }
    if (xx == v[last]) {
      last--;
    }
  }
  cout << n - last - 1;
}
