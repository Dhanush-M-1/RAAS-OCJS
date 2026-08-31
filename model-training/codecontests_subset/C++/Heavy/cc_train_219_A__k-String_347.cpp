#include <bits/stdc++.h>
using namespace std;
long long int b[111111];
long long int n, k, d, a[111111], sum, mx = 1, cnt = 1;
long long int vis[111111], lev[11111];
vector<vector<long long int>> v(111111);
map<string, vector<string>>::iterator it;
map<long long int, long long int> mp;
void dfs(long long int s) {
  lev[1] = 1;
  vis[s] = 1;
  for (int i = 0; i < v[s].size(); i++) {
    if (!vis[v[s][i]]) {
      cnt *= 2;
      dfs(v[s][i]);
    }
  }
}
int main() {
  char c;
  string s, r[111];
  long long int m, j = 0, k = 0, y, x, z, i, u = 0, d = 0, l = 0, x3 = 0;
  cin >> n;
  cin >> s;
  for (i = 0; i < s.length(); i++) {
    mp[s[i]]++;
  }
  for (c = 'a'; c <= 'z'; c++) {
    if (mp[c] % n != 0) {
      cout << -1;
      return 0;
    }
  }
  for (i = n; i > 0; i--) {
    for (c = 'a'; c <= 'z'; c++) {
      for (j = 0; j < mp[c] / i; j++) cout << c;
      mp[c] -= mp[c] / i;
    }
  }
}
