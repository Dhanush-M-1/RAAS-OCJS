#include <bits/stdc++.h>
using namespace std;
const unsigned long long hash1 = 201326611;
const unsigned long long hash2 = 50331653;
const int N = 200000 + 10;
const int M = 20;
vector<int> g[N];
int n, vis[N];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0), cout.tie(0);
  cin >> n;
  int u, v;
  for (int i = 1; i < n; i++) {
    cin >> u >> v;
    vis[u]++;
    vis[v]++;
  }
  int flag = 0;
  for (int i = 1; i <= n; i++) {
    if (vis[i] == 2) flag = 1;
  }
  if (flag)
    cout << "NO" << endl;
  else
    cout << "YES" << endl;
  return 0;
}
