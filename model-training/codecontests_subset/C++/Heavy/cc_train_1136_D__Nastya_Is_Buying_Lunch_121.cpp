#include <bits/stdc++.h>
using namespace std;
const int MX = (int)1e5 + 10;
int main(int argc, char* argv[]) {
  cin.tie(0);
  cout.tie(0);
  ios_base::sync_with_stdio(0);
  int n, m;
  cin >> n >> m;
  int a[n];
  for (int i = 0; i < n; ++i) {
    cin >> a[i];
    a[i]--;
  }
  set<int> g[n];
  vector<int> canPass(n);
  for (int i = 0; i < m; ++i) {
    int x, y;
    cin >> x >> y;
    --x, --y;
    g[x].insert(y);
    if (y == a[n - 1]) canPass[x] = true;
  }
  int res = 0;
  set<int> mustByPass;
  for (int i = n - 2; i >= 0; --i) {
    if (canPass[a[i]]) {
      bool ok = g[a[i]].size() >= mustByPass.size();
      for (auto& x : mustByPass) ok &= g[a[i]].find(x) != g[a[i]].end();
      res += ok;
      if (!ok) mustByPass.insert(a[i]);
    } else
      mustByPass.insert(a[i]);
  }
  cout << res << endl;
  return 0;
}
