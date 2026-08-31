#include <bits/stdc++.h>
using namespace std;
int n, s;
int a[200100];
int sorted[200100];
int been[200100];
map<int, list<int>> alive;
list<list<int>> sol;
void dfs(int val) {
  if (alive[val].empty()) return;
  int k = alive[val].front();
  alive[val].pop_front();
  been[k] = true;
  dfs(a[k]);
  sol.back().push_front(k);
  if (!alive[val].empty()) dfs(val);
}
int main() {
  cin >> n >> s;
  for (int i = 0; i < n; i++) cin >> a[i];
  for (int i = 0; i < n; i++) sorted[i] = a[i];
  sort(sorted, sorted + n);
  for (int i = 0; i < n; i++) {
    if (a[i] == sorted[i])
      been[i] = true;
    else {
      s--;
      alive[sorted[i]].push_back(i);
    }
  }
  if (s < 0) {
    cout << -1 << endl;
    return 0;
  }
  for (int i = 0; i < n; i++)
    if (!been[i]) {
      sol.push_back(list<int>());
      dfs(sorted[i]);
    }
  if (s > 2 && sol.size() > 2) {
    list<int> new_cycle;
    list<int> rev_cycle;
    int num = min((size_t)s, sol.size());
    for (int w = 0; w < num; w++) {
      list<int> &l = sol.back();
      rev_cycle.push_front(l.front());
      for (auto x : sol.back()) new_cycle.push_back(x);
      sol.pop_back();
    }
    sol.push_back(new_cycle);
    sol.push_back(rev_cycle);
  }
  cout << sol.size() << endl;
  for (list<int> &l : sol) {
    cout << l.size() << endl;
    for (int x : l) cout << x + 1 << " ";
    cout << endl;
  }
  return 0;
}
