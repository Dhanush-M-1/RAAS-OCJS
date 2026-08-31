#include <bits/stdc++.h>
using namespace std;
vector<int> v[200005], sol;
queue<int> q;
int deg[200005], t[200005];
bool viz[200005];
void dfs(int i);
void afiseaza(int i);
int main() {
  int n, i, a, wait, root;
  cin >> n;
  for (i = 1; i <= n; ++i) {
    cin >> a;
    t[i] = a;
    if (a) {
      v[i].push_back(a);
      v[a].push_back(i);
      ++deg[a];
      ++deg[i];
    } else {
      root = i;
    }
  }
  dfs(root);
  if (sol.size() < n) {
    cout << "NO\n";
    return 0;
  }
  cout << "YES\n";
  for (auto it = sol.begin(); it != sol.end(); ++it) {
    cout << *it << '\n';
  }
}
void dfs(int i) {
  for (auto it = v[i].begin(); it != v[i].end(); ++it) {
    if (*it != t[i]) {
      dfs(*it);
    }
  }
  if (deg[i] % 2 == 0) {
    afiseaza(i);
    --deg[t[i]];
  }
}
void afiseaza(int i) {
  viz[i] = 1;
  sol.push_back(i);
  for (auto it = v[i].begin(); it != v[i].end(); ++it) {
    if (*it != t[i] && !viz[*it]) {
      afiseaza(*it);
    }
  }
}
