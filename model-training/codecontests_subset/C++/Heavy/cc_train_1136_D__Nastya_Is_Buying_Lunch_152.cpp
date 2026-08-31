#include <bits/stdc++.h>
using namespace std;
int n, m, u, v;
vector<int> p;
set<pair<int, int> > s;
int main() {
  std::ios_base::sync_with_stdio(false);
  cin >> n >> m;
  p = vector<int>(n);
  for (int i = 0; i < n; i++) cin >> p[i];
  int pn = p[n - 1];
  for (int i = 0; i < m; i++) {
    cin >> u >> v;
    s.insert(make_pair(u, v));
  }
  int i = n - 2;
  while (i >= 0) {
    auto it = s.find(make_pair(p[i], p[i + 1]));
    if (it != s.end()) {
      swap(p[i], p[i + 1]);
      s.erase(it);
      if (p[i] == pn)
        i--;
      else
        i++;
    } else {
      i--;
    }
  }
  for (int i = 0; i < n; i++)
    if (p[i] == pn) {
      cout << (n - i - 1) << endl;
      break;
    }
}
