#include <bits/stdc++.h>
using namespace std;
using LL = long long;
const int MAXN = 200010;
vector<int> x[MAXN], y[MAXN];
int v[MAXN], out[MAXN], sg[MAXN];
int xr[MAXN];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int n, m;
  cin >> n >> m;
  for (int i = 0; i < n; ++i) cin >> v[i];
  for (int i = 0; i < m; ++i) {
    int a, b;
    cin >> a >> b;
    --a;
    --b;
    x[a].push_back(b);
    y[b].push_back(a);
    ++out[a];
  }
  queue<int> Q;
  for (int i = 0; i < n; ++i) {
    if (out[i] == 0) Q.push(i);
  }
  int maxsg = 0;
  while (!Q.empty()) {
    int a = Q.front();
    Q.pop();
    for (int b : y[a]) {
      --out[b];
      if (out[b] == 0) {
        Q.push(b);
      }
    }
    set<int> s;
    for (int b : x[a]) s.insert(sg[b]);
    for (int i = 0; i < n; ++i) {
      if (s.find(i) == s.end()) {
        sg[a] = i;
        break;
      }
    }
    maxsg = max(maxsg, sg[a]);
  }
  for (int i = 0; i < n; ++i) {
    xr[sg[i]] ^= v[i];
  }
  bool win = false;
  for (int i = maxsg; i >= 0; --i) {
    if (xr[i] != 0) {
      win = true;
      int p = -1;
      for (int j = 0; j < n; ++j) {
        if (sg[j] != i) continue;
        if (p == -1) {
          p = j;
          continue;
        }
        if ((v[j] ^ xr[i]) <= v[j]) p = j;
      }
      xr[i] ^= v[p];
      v[p] = xr[i];
      xr[i] = 0;
      for (int b : x[p]) {
        if (xr[sg[b]] != 0) {
          v[b] ^= xr[sg[b]];
          xr[sg[b]] = 0;
        }
      }
      break;
    }
  }
  if (win) {
    cout << "WIN\n";
    for (int i = 0; i < n; ++i) cout << v[i] << " ";
    cout << '\n';
  } else {
    cout << "LOSE\n";
  }
  return 0;
}
