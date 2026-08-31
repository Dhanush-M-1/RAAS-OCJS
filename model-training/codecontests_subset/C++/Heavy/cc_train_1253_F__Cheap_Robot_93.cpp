#include <bits/stdc++.h>
using namespace std;
const long long MAXN = 3e5 + 5;
long long k, n, m, q, ta, tb, tc;
long long dis[MAXN];
long long dkt[MAXN];
long long dep[MAXN];
long long ma[22][MAXN];
long long p[22][MAXN];
vector<long long> v0[MAXN];
vector<long long> w0[MAXN];
vector<long long> v[MAXN];
vector<long long> w[MAXN];
vector<pair<long long, pair<long long, long long> > > isi;
long long P[MAXN];
void djik() {
  priority_queue<pair<long long, pair<long long, long long> > > pq;
  for (long long i = 1; i <= n; i++) {
    dis[i] = 1e18;
    if (i <= k) {
      dis[i] = 0;
      dkt[i] = i;
      pq.push(make_pair(0, make_pair(i, i)));
    }
  }
  while (!pq.empty()) {
    long long jar = -pq.top().first;
    long long u = pq.top().second.first;
    long long dk = pq.top().second.second;
    pq.pop();
    for (long long i = 0; i < v0[u].size(); i++) {
      long long nx = v0[u][i];
      long long wx = jar + w0[u][i];
      if (dis[nx] > wx) {
        dis[nx] = wx;
        dkt[nx] = dk;
        pq.push(make_pair(-wx, make_pair(nx, dk)));
      } else if (dkt[nx] != dk) {
        isi.push_back(make_pair(dis[nx] + wx, make_pair(dkt[nx], dk)));
      }
    }
  }
}
void dfs(long long pos, long long par, long long dlm) {
  dep[pos] = dlm;
  p[0][pos] = par;
  for (long long i = 1; i <= 20; i++) {
    p[i][pos] = p[i - 1][p[i - 1][pos]];
    ma[i][pos] = max(ma[i - 1][pos], ma[i - 1][p[i - 1][pos]]);
  }
  for (long long i = 0; i < v[pos].size(); i++) {
    long long nx = v[pos][i];
    if (nx == par) continue;
    ma[0][nx] = w[pos][i];
    dfs(nx, pos, dlm + 1);
  }
}
long long LCA(long long A, long long B) {
  long long H = 0;
  if (dep[A] < dep[B]) swap(A, B);
  for (long long i = 20; i >= 0; i--)
    if (dep[A] - (1 << i) >= dep[B]) {
      H = max(H, ma[i][A]);
      A = p[i][A];
    }
  if (A == B) return H;
  for (long long i = 20; i >= 0; i--)
    if (p[i][A] != p[i][B]) {
      H = max(H, ma[i][A]);
      H = max(H, ma[i][B]);
      A = p[i][A];
      B = p[i][B];
    }
  H = max(H, ma[0][A]);
  H = max(H, ma[0][B]);
  return H;
}
long long car(long long A) {
  if (P[A] == A)
    return A;
  else
    return P[A] = car(P[A]);
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> m >> k >> q;
  for (long long i = 1; i <= m; i++) {
    P[i] = i;
    cin >> ta >> tb >> tc;
    v0[ta].push_back(tb);
    w0[ta].push_back(tc);
    v0[tb].push_back(ta);
    w0[tb].push_back(tc);
  }
  djik();
  sort(isi.begin(), isi.end());
  for (long long i = 0; i < isi.size(); i++) {
    if (car(isi[i].second.first) != car(isi[i].second.second)) {
      v[isi[i].second.first].push_back(isi[i].second.second);
      w[isi[i].second.first].push_back(isi[i].first);
      v[isi[i].second.second].push_back(isi[i].second.first);
      w[isi[i].second.second].push_back(isi[i].first);
      P[car(isi[i].second.first)] = car(isi[i].second.second);
    }
  }
  dfs(1, 1, 0);
  while (q--) {
    cin >> ta >> tb;
    cout << LCA(ta, tb) << "\n";
  }
}
