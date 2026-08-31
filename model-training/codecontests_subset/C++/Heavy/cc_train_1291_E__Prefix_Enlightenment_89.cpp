#include <bits/stdc++.h>
using namespace std;
const int N = 3e5 + 69;
int n, k;
string initial;
int dsu[N];
int sz[N];
int szsame[N];
int parity[N];
int restrict[N];
vector<int> belong[N];
int curr = 0;
int getVal(int u) {
  if (restrict[u] == 0) return szsame[u];
  if (restrict[u] == 1) return (sz[u] - szsame[u]);
  return min(szsame[u], sz[u] - szsame[u]);
}
pair<int, int> find(int u) {
  if (dsu[u] != u) {
    pair<int, int> res = find(dsu[u]);
    dsu[u] = res.first;
    if (parity[u])
      parity[u] = res.second;
    else
      parity[u] = res.second ^ 1;
    return make_pair(dsu[u], parity[u]);
  }
  return make_pair(u, 1);
}
int funion(int u, int v, bool same) {
  pair<int, int> r1 = find(u);
  pair<int, int> r2 = find(v);
  if (r1.first == r2.first) return 0;
  if (sz[r1.first] < sz[r2.first]) swap(r1, r2);
  int init = getVal(r1.first) + getVal(r2.first);
  dsu[r2.first] = r1.first;
  sz[r1.first] += sz[r2.first];
  bool rsame = true;
  if (same && r1.second != r2.second) rsame = false;
  if (!same && r1.second == r2.second) rsame = false;
  if (!rsame) parity[r2.first] = 0;
  if (restrict[r2.first] < 2) {
    if (rsame)
      restrict[r1.first] = restrict[r2.first];
    else
      restrict[r1.first] = restrict[r2.first] ^ 1;
  }
  if (rsame)
    szsame[r1.first] += szsame[r2.first];
  else
    szsame[r1.first] += sz[r2.first] - szsame[r2.first];
  return getVal(r1.first) - init;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> n >> k;
  cin >> initial;
  for (int i = 0; i < k; i++) {
    int t;
    cin >> t;
    for (int j = 0; j < t; j++) {
      int l;
      cin >> l;
      l--;
      belong[l].push_back(i);
    }
    dsu[i] = i;
    sz[i] = 1;
    szsame[i] = 1;
    parity[i] = 1;
    restrict[i] = 2;
  }
  for (int i = 0; i < n; i++) {
    if (belong[i].size() == 1) {
      int u = belong[i][0];
      pair<int, int> res = find(u);
      int init = getVal(res.first);
      if (initial[i] == '0') {
        if (res.second)
          restrict[res.first] = 0;
        else
          restrict[res.first] = 1;
      } else {
        if (res.second)
          restrict[res.first] = 1;
        else
          restrict[res.first] = 0;
      }
      curr += getVal(res.first) - init;
    } else if (belong[i].size() == 2) {
      bool same = (initial[i] == '1');
      int u = belong[i][0];
      int v = belong[i][1];
      curr += funion(u, v, same);
    }
    cout << curr << '\n';
  }
}
