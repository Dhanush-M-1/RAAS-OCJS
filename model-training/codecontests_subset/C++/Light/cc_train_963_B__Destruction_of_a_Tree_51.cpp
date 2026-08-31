#include <bits/stdc++.h>
using namespace std;
const int MX = 1147483646;
const long long MX2 = 9223372036854775800;
const int MOD = 1e9 + 9;
int n;
vector<int> tr[200011];
vector<int> destr[200011];
int sz[200011];
bool des[200011], visited[200011];
void dest(int& id) {
  cout << id << "\n";
  des[id] = 1;
  for (int x : destr[id]) sz[x]--;
  return;
}
void dfs(int id) {
  bool rep = 1;
  if (visited[id] && !des[id] && sz[id] % 2 == 0) {
    rep = 0;
    dest(id);
  }
  visited[id] = 1;
  for (int x : tr[id]) {
    if (des[x]) continue;
    dfs(x);
  }
  if (!des[id] && sz[id] % 2 == 0) {
    dest(id);
    for (int x : tr[id]) {
      if (des[x]) continue;
      dfs(x);
    }
  }
  return;
}
int main() {
  cin.tie(NULL);
  ios::sync_with_stdio(false);
  int i, x;
  cin >> n;
  int rt;
  for (i = 1; i <= n; i++) {
    cin >> x;
    if (x) {
      tr[x].push_back(i);
      destr[x].push_back(i);
      destr[i].push_back(x);
      sz[i]++;
      sz[x]++;
    } else
      rt = i;
  }
  if (n & 1) {
    cout << "YES\n";
    dfs(rt);
  } else {
    cout << "NO";
  }
  return 0;
}
