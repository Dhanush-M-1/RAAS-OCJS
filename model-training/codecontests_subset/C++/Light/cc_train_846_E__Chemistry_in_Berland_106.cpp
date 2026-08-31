#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 5;
const long long inf = 1e18;
long long materials[N];
vector<vector<pair<int, long long>>> edge(N);
int n;
pair<long long, long long> dfs(int now) {
  long long need = max(-materials[now], 0LL);
  long long supply = max(materials[now], 0LL);
  for (pair<int, long long> it : edge[now]) {
    pair<long long, long long> ret = dfs(it.first);
    if (ret.first > inf / it.second) {
      cout << "NO" << endl;
      exit(0);
    } else {
      need = need + ret.first * it.second;
    }
    if (need > inf) {
      cout << "NO" << endl;
      exit(0);
    }
    supply = supply + ret.second;
  }
  if (need < supply) {
    return {0, supply - need};
  } else if (supply < need) {
    return {need - supply, 0};
  } else {
    return {0, 0};
  }
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    cin >> materials[i];
  }
  for (int i = 1; i <= n; i++) {
    long long temp;
    cin >> temp;
    materials[i] = materials[i] - temp;
  }
  for (int i = 2; i <= n; i++) {
    int x, k;
    scanf("%d%d", &x, &k);
    edge[x].emplace_back(i, k);
  }
  pair<long long, long long> ret = dfs(1);
  if (ret.first > 0)
    cout << "NO" << endl;
  else
    cout << "YES" << endl;
}
