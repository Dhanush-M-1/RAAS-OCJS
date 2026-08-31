#include <bits/stdc++.h>
using namespace std;
long long n, a[100003], b[100003], k[100003], x[100003];
vector<int> v[100003];
bool vis[100003];
long long dfs(int x) {
  vis[x] = 1;
  long long ret = b[x] - a[x];
  for (int i = 0; i < v[x].size(); i++) {
    long long re = dfs(v[x][i]);
    if (re >= 0)
      ret += re;
    else {
      if ((re / 1000000000) * k[v[x][i]] < -2 * pow(10, 8)) {
        cout << "NO";
        exit(0);
      }
      ret += re * k[v[x][i]];
      if (ret < -2 * pow(10, 17)) {
        cout << "NO";
        exit(0);
      }
    }
  }
  return ret;
}
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) cin >> b[i];
  for (int i = 0; i < n; i++) cin >> a[i];
  for (int i = 1; i < n; i++) cin >> x[i] >> k[i], v[x[i] - 1].push_back(i);
  if (dfs(0) >= 0)
    cout << "YES";
  else
    cout << "NO";
}
