#include <bits/stdc++.h>
using namespace std;
int main() {
  long long m, n, i;
  string s, t, u, v;
  vector<pair<string, string> > vec;
  cin >> u >> v >> n;
  vec.push_back(make_pair(u, v));
  for (i = 1; i <= n; i++) {
    cin >> s >> t;
    if (s == u) {
      u = t;
      vec.push_back(make_pair(u, v));
    } else if (s == v) {
      v = t;
      vec.push_back(make_pair(u, v));
    }
  }
  for (i = 0; i <= n; i++) cout << vec[i].first << " " << vec[i].second << endl;
}
