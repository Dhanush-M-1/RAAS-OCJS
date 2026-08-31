#include <bits/stdc++.h>
using namespace std;
const int maxi = 1e6 + 2;
int a[maxi], b[maxi];
int res[maxi];
vector<int> v[maxi];
string s;
int n, m, k;
int ok;
int rem[maxi];
int deg[maxi];
map<pair<int, int>, int> mp;
queue<int> q;
void skloni(int poz) {
  while (!q.empty()) {
    int x = q.front();
    deg[x] = 0;
    q.pop();
    for (int i : v[x]) {
      if (!rem[i] && deg[i] == k && !mp[{x, i}]) {
        deg[i]--;
        res[poz]--;
        q.push(i);
        rem[i] = 1;
        mp[{x, i}] = 1;
        mp[{i, x}] = 1;
      } else {
        if (!mp[{x, i}]) deg[i]--;
        mp[{x, i}] = 1;
        mp[{i, x}] = 1;
      }
    }
  }
}
int main() {
  cin >> n >> m >> k;
  for (int i = 1; i <= m; i++) {
    int x, y;
    scanf("%d%d", &x, &y);
    a[i] = x;
    b[i] = y;
    v[x].push_back(y);
    v[y].push_back(x);
    deg[x]++;
    deg[y]++;
  }
  res[m] = n;
  for (int i = 1; i <= n; i++)
    if (deg[i] < k) {
      q.push(i);
      rem[i] = 1;
      res[m]--;
    }
  skloni(m);
  for (int i = m; i >= 1; i--) {
    res[i - 1] = res[i];
    if (!mp[{a[i], b[i]}]) {
      deg[a[i]]--;
      deg[b[i]]--;
      mp[{a[i], b[i]}] = 1;
      mp[{b[i], a[i]}] = 1;
      if (deg[a[i]] == k - 1 && !rem[a[i]]) {
        rem[a[i]] = 1;
        res[i - 1]--;
        q.push(a[i]);
      };
      if (deg[b[i]] == k - 1 && !rem[b[i]]) {
        rem[b[i]] = 1;
        res[i - 1]--;
        q.push(b[i]);
      };
      skloni(i - 1);
    }
  }
  for (int i = 1; i <= m; i++) printf("%d\n", res[i]);
  return 0;
}
