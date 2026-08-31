#include <bits/stdc++.h>
using namespace std;
const int N = 2 * 100 * 1000 + 10;
int n, startPoint;
int sz[N], out[N];
vector<int> child[N], in[N];
void input() {
  cin.tie(0);
  cin >> n;
  for (int i = 0, u; i < n; i++) {
    cin >> u;
    if (u != 0)
      child[u - 1].push_back(i);
    else
      startPoint = i;
  }
  return;
}
int DFS(int v) {
  int res = 1;
  for (auto u : child[v]) {
    int tmp = DFS(u);
    if (tmp % 2) {
      in[v].push_back(u);
      out[u]++;
    } else {
      in[u].push_back(v);
      out[v]++;
    }
    res += tmp;
  }
  return res;
}
void solve() {
  cout.tie(0);
  cout << "YES\n";
  set<pair<int, int> > st;
  for (int i = 0; i < n; i++) st.insert({out[i], i});
  for (int i = 0; i < n; i++) {
    pair<int, int> p = *(st.begin());
    st.erase(st.begin());
    cout << p.second + 1 << '\n';
    for (auto u : in[p.second]) {
      st.erase({out[u], u});
      st.insert({--out[u], u});
    }
  }
  return;
}
int main() {
  ios::sync_with_stdio(false);
  input();
  if (n % 2) {
    DFS(startPoint);
    solve();
  } else
    cout << "NO" << endl;
  return 0;
}
