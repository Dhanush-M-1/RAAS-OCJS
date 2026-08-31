#include <bits/stdc++.h>
using namespace std;
int const oo = 1e9, bound = 3e6 + 1, mod = oo + 7, N = 2e5 + 1, CON = 30000001;
long long const OO = 1e18;
int n, x, nxt[1001], in[1001], dp[1001][1001];
vector<int> con;
int go(int u, bool care) {
  int ret = 1;
  if (u == x && care) return 0;
  while (nxt[u] != -1) {
    if (u == x && care) return 0;
    u = nxt[u], ret++;
  }
  if (u == x && care) return 0;
  return ret;
}
int rec(int idx, int pos) {
  int &ret = dp[idx][pos];
  if (ret != -1) return ret;
  if (idx == (int)con.size()) return ret = pos == 0;
  if (pos == 0) return ret = 1;
  int r1 = 0, r2 = 0;
  if (pos - con[idx] >= 0) r1 = rec(idx + 1, pos - con[idx]);
  r2 = rec(idx + 1, pos);
  return ret = r1 || r2;
}
int main() {
  memset(nxt, -1, sizeof nxt);
  memset(dp, -1, sizeof dp);
  cin >> n >> x;
  x--;
  for (int(i) = 0; (i) < (n); (i)++) {
    cin >> nxt[i];
    in[--nxt[i]]++;
  }
  for (int(i) = 0; (i) < (n); (i)++)
    if (!in[i]) {
      int op = go(i, 1);
      if (op) con.push_back(op);
    }
  int my = go(x, 0);
  set<int> res;
  res.insert(my);
  for (int(i) = 1; (i) <= (n); (i)++)
    if (i > my && rec(0, i - my)) res.insert(i);
  for (auto a : res) cout << a << endl;
  return 0;
}
