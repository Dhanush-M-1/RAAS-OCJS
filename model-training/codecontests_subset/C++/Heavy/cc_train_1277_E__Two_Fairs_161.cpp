#include <bits/stdc++.h>
using namespace std;
const long long MOD = 1000000007;
vector<long long> adj[200003];
vector<bool> visited;
long long a, b;
vector<long long> par1, par2;
void dfs_a(long long s, long long par) {
  if (!visited[s]) {
    visited[s] = true;
    par1[s] = par;
    for (auto x : adj[s]) {
      dfs_a(x, par);
    }
  }
}
void dfs_b(long long s, long long par) {
  if (!visited[s]) {
    visited[s] = true;
    par2[s] = par;
    for (auto x : adj[s]) {
      dfs_b(x, par);
    }
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long n, i, j, k, t, temp;
  long long tc;
  cin >> tc;
  while (tc--) {
    long long m;
    cin >> n >> m >> a >> b;
    visited.clear();
    visited.resize(n + 1);
    par1.resize(n + 1);
    par2.resize(n + 1);
    long long tot = 0;
    tot = (n - 2) * (n - 3);
    tot /= 2;
    for (i = 1; i <= n; i++) {
      adj[i].clear();
      par1[i] = i;
      par2[i] = i;
    }
    for (i = 1; i <= m; i++) {
      cin >> j >> k;
      adj[j].push_back(k);
      adj[k].push_back(j);
    }
    for (i = 1; i <= n; i++) {
      visited[i] = false;
    }
    visited[b] = true;
    for (i = 1; i <= n; i++) {
      if (!visited[i]) {
        dfs_a(i, i);
      }
    }
    for (i = 1; i <= n; i++) {
      visited[i] = false;
    }
    visited[a] = true;
    for (i = 1; i <= n; i++) {
      if (!visited[i]) {
        dfs_b(i, i);
      }
    }
    map<pair<long long, long long>, long long> both;
    map<long long, long long> just_a, just_b;
    for (i = 1; i <= n; i++) {
      if (i != a & i != b) {
        just_a[par1[i]]++;
        just_b[par2[i]]++;
        both[{par1[i], par2[i]}]++;
      }
    }
    long long ans_a = 0, ans_b = 0, ans_ab = 0;
    for (auto x : just_a) {
      ans_a += (x.second * (x.second - 1)) / 2;
    }
    for (auto x : just_b) {
      ans_b += (x.second * (x.second - 1)) / 2;
    }
    for (auto x : both) {
      ans_ab += (x.second * (x.second - 1)) / 2;
    }
    tot = tot - ans_a - ans_b + ans_ab;
    cout << tot << endl;
  }
  return 0;
}
