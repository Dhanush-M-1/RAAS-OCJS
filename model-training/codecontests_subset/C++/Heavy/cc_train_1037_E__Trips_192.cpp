#include <bits/stdc++.h>
using namespace std;
int n, m, k;
set<int> V[200200];
pair<int, int> edges[200200];
set<int> active;
int answer[200200];
void fix(int i) {
  if (active.find(i) == active.end()) return;
  if (V[i].size() < k) {
    for (int x : V[i]) V[x].erase(i);
    for (int x : V[i]) fix(x);
    active.erase(i);
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin >> n >> m >> k;
  for (int i = 0; i < m; i++) {
    int x, y;
    cin >> x >> y;
    edges[i].first = x;
    edges[i].second = y;
    V[x].insert(y);
    V[y].insert(x);
  }
  for (int i = 1; i <= n; i++) active.insert(i);
  for (int i = 1; i <= n; i++) fix(i);
  for (int i = m - 1; i >= 0; i--) {
    answer[i] = active.size();
    int x = edges[i].first, y = edges[i].second;
    V[x].erase(y);
    V[y].erase(x);
    fix(x);
    fix(y);
  }
  for (int i = 0; i < m; i++) cout << answer[i] << "\n";
}
