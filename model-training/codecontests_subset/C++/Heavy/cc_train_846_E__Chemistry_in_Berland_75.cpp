#include <bits/stdc++.h>
using namespace std;
vector<pair<unsigned long long, unsigned long long>> graph[100110];
unsigned long long n, a[100100], b[100100], have[100100], need[100100];
bool visted[100100];
pair<long long, long long> dfs(int v, int push) {
  visted[v] = true;
  long long h = have[v], N = need[v], cary = 1;
  have[v] = 0;
  for (auto u : graph[v]) {
    if (!visted[u.first]) {
      pair<long long, long long> curr = dfs(u.first, v);
      h += curr.first;
      N += curr.second * u.second;
    }
    if (u.first == push) cary = u.second;
  }
  if (N >= h) {
    N -= h;
    h = 0;
  } else {
    h -= N;
    N = 0;
  }
  return {h / cary, N};
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> n;
  for (int i = 0; i < n; i++) cin >> b[i + 1];
  for (int i = 0; i < n; i++) cin >> a[i + 1];
  for (int i = 0; i < n; i++) {
    have[i + 1] = max((unsigned long long)0, b[i + 1] - a[i + 1]);
    need[i + 1] = max((unsigned long long)0, a[i + 1] - b[i + 1]);
    if (i >= 1) {
      long long first, k;
      cin >> first >> k;
      graph[i + 1].push_back({first, 1});
      graph[first].push_back({i + 1, k});
    }
  }
  for (int i = n; i >= 1; i--) {
    if (!visted[i]) {
      if (dfs(i, 0).second != 0) return cout << "NO", 0;
    }
  }
  cout << "YES";
}
