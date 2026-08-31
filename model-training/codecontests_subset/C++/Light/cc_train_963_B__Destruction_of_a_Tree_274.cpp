#include <bits/stdc++.h>
using namespace std;
const int NMAX = 200005;
int n, rad, nr[NMAX], sol[NMAX], dim;
vector<int> L[NMAX];
bitset<NMAX> viz;
inline void DFS_SOLVE(int x) {
  viz[x] = 1;
  sol[++dim] = x;
  for (auto i : L[x])
    if (!viz[i]) DFS_SOLVE(i);
}
void DFS(int node) {
  nr[node] = 1;
  for (auto i : L[node]) {
    DFS(i);
    nr[node] += nr[i];
  }
  if (!(nr[node] % 2)) DFS_SOLVE(node);
}
int main() {
  int x;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> x;
    if (!x)
      rad = i;
    else
      L[x].push_back(i);
  }
  DFS(rad);
  DFS_SOLVE(rad);
  if (dim > n)
    cout << "NO\n";
  else {
    cout << "YES\n";
    for (int i = 1; i <= dim; i++) cout << sol[i] << "\n";
  }
  return 0;
}
