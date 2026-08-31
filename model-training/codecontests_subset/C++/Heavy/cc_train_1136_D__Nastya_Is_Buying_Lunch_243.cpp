#include <bits/stdc++.h>
#pragma comment(linker, "/stack:247474112")
#pragma GCC optimize("Ofast")
using namespace std;
const int INF = 0x3f3f3f3f;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n, m;
  cin >> n >> m;
  vector<int> p(n, 0);
  for (long long i = 0; i < n; ++i) {
    cin >> p[i];
    --p[i];
  }
  set<int> fw[n];
  for (long long i = 0; i < m; ++i) {
    int u, v;
    cin >> u >> v;
    fw[--v].insert(--u);
  }
  int id = p[n - 1];
  int ans = 0;
  for (int i = n - 1; i > 0; --i) {
    if (fw[p[i]].find(p[i - 1]) != fw[p[i]].end()) {
      fw[p[i]].erase(p[i - 1]);
      swap(p[i], p[i - 1]);
      if (p[i - 1] == id) {
        ++ans;
      } else {
        i += 2;
      }
    }
  }
  cout << ans << endl;
}
