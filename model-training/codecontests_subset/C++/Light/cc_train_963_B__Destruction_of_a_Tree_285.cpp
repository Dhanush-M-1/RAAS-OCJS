#include <bits/stdc++.h>
using namespace std;
const int N = 3e5 + 5;
int n, x, a[N];
vector<int> g[N], q1, q2;
void dfs(int v, int pr = 0) {
  for (int to : g[v]) {
    if (to != pr) {
      dfs(to, v);
    }
  }
  if (a[v] % 2 == 0) {
    q1.push_back(v);
    a[pr]--;
  } else {
    q2.push_back(v);
  }
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> x;
    if (x) {
      a[x]++;
      a[i]++;
      g[i].push_back(x);
      g[x].push_back(i);
    }
  }
  dfs(1);
  reverse(q2.begin(), q2.end());
  for (auto it : q2) {
    q1.push_back(it);
  }
  for (int i = 1; i <= n; i++) {
    a[i] = g[i].size();
  }
  for (auto it : q1) {
    if (a[it] & 1) {
      return cout << "NO", 0;
    }
    for (auto to : g[it]) {
      a[to]--;
    }
  }
  cout << "YES\n";
  for (auto it : q1) {
    cout << it << "\n";
  }
}
