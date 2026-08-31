#include <bits/stdc++.h>
using namespace std;
pair<int, int> v[200100];
int lv[200100];
vector<int> gr[200100];
int in[200100];
vector<int> go;
map<pair<int, int>, int> taiat;
int n, m, k, cont;
void dfs(int nod) {
  in[nod] = 0;
  cont--;
  for (auto &x : gr[nod]) {
    if (taiat[{nod, x}]) {
      continue;
    }
    taiat[{nod, x}] = 1;
    taiat[{x, nod}] = 1;
    lv[x]--;
    if (in[x] && lv[x] < k) {
      dfs(x);
    }
  }
}
vector<int> ans;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> n >> m >> k;
  cont = n;
  for (int i = 1; i <= m; i++) {
    cin >> v[i].first >> v[i].second;
    gr[v[i].first].push_back(v[i].second);
    gr[v[i].second].push_back(v[i].first);
    lv[v[i].first]++;
    lv[v[i].second]++;
  }
  for (int i = 1; i <= n; i++) {
    in[i] = 1;
  }
  for (int i = 1; i <= n; i++) {
    if (lv[i] < k) {
      go.push_back(i);
    }
  }
  for (auto &x : go) {
    if (in[x]) {
      dfs(x);
    }
  }
  for (int i = m; i >= 1; i--) {
    ans.push_back(cont);
    if (taiat[{v[i].first, v[i].second}]) {
      continue;
    }
    taiat[{v[i].first, v[i].second}] = 1;
    taiat[{v[i].second, v[i].first}] = 1;
    lv[v[i].first]--;
    lv[v[i].second]--;
    if (lv[v[i].first] < k && in[v[i].first]) {
      dfs(v[i].first);
    }
    if (lv[v[i].second] < k && in[v[i].second]) {
      dfs(v[i].second);
    }
  }
  reverse(ans.begin(), ans.end());
  for (auto &x : ans) {
    cout << x << '\n';
  }
  return 0;
}
