#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 2;
vector<int> adj[N], in[N], idx[N];
int mex[N], val[N], h[N], deg[N];
bool used[N];
queue<int> lis;
signed main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int n, m, i, j, k, l, max1;
  cin >> n >> m;
  for (i = 1; i <= n; i++) {
    cin >> h[i];
  }
  for (i = 1; i <= m; i++) {
    cin >> j >> k;
    adj[j].push_back(k);
    deg[j]++;
    in[k].push_back(j);
  }
  for (i = 1; i <= n; i++) {
    if (!deg[i]) {
      lis.push(i);
    }
  }
  while (lis.size()) {
    int x = lis.front();
    lis.pop();
    for (i = 0; i < adj[x].size(); i++) {
      used[mex[adj[x][i]]] = true;
    }
    for (i = 0; i < in[x].size(); i++) {
      deg[in[x][i]]--;
      if (!deg[in[x][i]]) {
        lis.push(in[x][i]);
      }
    }
    j = 0;
    while (used[j]) {
      j++;
    }
    for (i = 0; i < adj[x].size(); i++) {
      used[mex[adj[x][i]]] = false;
    }
    idx[j].push_back(x);
    mex[x] = j;
    val[j] ^= h[x];
  }
  for (i = n; i > -1; i--) {
    if (val[i] > 0) {
      max1 = i;
      break;
    } else {
      if (i == 0) {
        cout << "LOSE";
        return 0;
      }
    }
  }
  cout << "WIN\n";
  for (i = 0; i < idx[max1].size(); i++) {
    int x = idx[max1][i];
    if (h[x] > (h[x] ^ val[max1])) {
      h[x] ^= val[max1];
      val[max1] = 0;
      for (j = 0; j < adj[x].size(); j++) {
        if (val[mex[adj[x][j]]]) {
          h[adj[x][j]] ^= val[mex[adj[x][j]]];
          val[mex[adj[x][j]]] = 0;
        }
      }
      break;
    }
  }
  for (i = 1; i <= n; i++) {
    cout << h[i] << ' ';
  }
}
