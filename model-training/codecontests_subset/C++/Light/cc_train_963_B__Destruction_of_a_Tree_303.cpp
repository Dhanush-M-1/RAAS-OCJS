#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 5;
vector<int> edges[N];
int state[N];
void cal(int prt, int cur, vector<int> &ans) {
  ans.push_back(cur);
  state[cur] = 1;
  for (int next : edges[cur]) {
    if (next == prt) continue;
    if (state[next] == 0) cal(cur, next, ans);
  }
}
int dfs(int prt, int cur, vector<int> &ans) {
  int dsum = 0;
  for (int next : edges[cur]) {
    if (next == prt) continue;
    dsum += dfs(cur, next, ans);
  }
  if (prt != 0) dsum += 1;
  if (dsum % 2 == 0) {
    cal(prt, cur, ans);
    return 0;
  } else
    return 1;
}
int main() {
  int n;
  cin >> n;
  for (int i = 1; i <= n; i += 1) {
    int p;
    cin >> p;
    if (p != 0) {
      edges[i].push_back(p);
      edges[p].push_back(i);
    }
  }
  vector<int> ans;
  dfs(0, 1, ans);
  if (ans.size() != n) {
    cout << "NO" << endl;
  } else {
    cout << "YES" << endl;
    for (int x : ans) cout << x << endl;
  }
}
