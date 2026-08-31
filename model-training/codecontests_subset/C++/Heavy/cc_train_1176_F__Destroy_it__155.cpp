#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f;
const long long LINF = 0x3f3f3f3f3f3f3f3fll;
long long dp[200001][11];
vector<vector<vector<long long> > > turnos;
long long n, turno;
long long solve2(long long pegas, long long dobro) {
  long long resp, ma1, ma2, segMa1, terMa1;
  if (pegas == 1) {
    resp = -LINF;
    for (long long el : turnos[turno][0]) {
      resp = max(resp, el);
    }
    for (long long el : turnos[turno][1]) {
      resp = max(resp, el);
    }
    for (long long el : turnos[turno][2]) {
      resp = max(resp, el);
    }
    if (resp == -LINF) {
      return resp;
    }
    if (dobro) {
      return 2 * resp;
    }
    return resp;
  }
  if (pegas == 2) {
    ma1 = -LINF, segMa1 = -LINF, ma2 = -LINF;
    if (turnos[turno][0].size() >= 1) {
      ma1 = turnos[turno][0][0];
    }
    if (turnos[turno][0].size() >= 2) {
      segMa1 = turnos[turno][0][1];
    }
    if (turnos[turno][1].size() >= 1) {
      ma2 = turnos[turno][1][0];
    }
    if (ma1 + segMa1 > ma1 + ma2) {
      if (ma1 == -LINF || segMa1 == -LINF) {
        return -LINF;
      }
      if (dobro) {
        return ma1 + segMa1 + max(ma1, segMa1);
      }
      return ma1 + segMa1;
    } else {
      if (ma1 == -LINF || ma2 == -LINF) {
        return -LINF;
      }
      if (dobro) {
        return ma1 + ma2 + max(ma1, ma2);
      }
      return ma1 + ma2;
    }
  }
  if (pegas == 3) {
    ma1 = -LINF, segMa1 = -LINF;
    terMa1 = -LINF;
    if (turnos[turno][0].size() >= 1) {
      ma1 = turnos[turno][0][0];
    }
    if (turnos[turno][0].size() >= 2) {
      segMa1 = turnos[turno][0][1];
    }
    if (turnos[turno][0].size() >= 3) {
      terMa1 = turnos[turno][0][2];
    }
    if (ma1 == -LINF || segMa1 == -LINF || terMa1 == -LINF) {
      return -LINF;
    }
    if (dobro) {
      return ma1 + segMa1 + terMa1 + max({ma1, segMa1, terMa1});
    }
    return ma1 + segMa1 + terMa1;
  }
  return 0;
}
long long solve(long long at, long long jogadas) {
  if (at == n) {
    return 0;
  }
  if (dp[at][jogadas] != -1) {
    return dp[at][jogadas];
  }
  long long resp = 0;
  for (long long I = 0; I <= 3; I++) {
    long long dobro = 0;
    if (jogadas + I >= 10) {
      dobro = 1;
    }
    turno = at;
    long long ganho = solve2(I, dobro);
    if (ganho != -LINF) {
      resp = max(resp, ganho + solve(at + 1, (jogadas + I) % 10));
    }
  }
  return dp[at][jogadas] = resp;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> n;
  turnos.resize(n, vector<vector<long long> >(3));
  for (long long I = 0; I < n; I++) {
    long long k;
    cin >> k;
    map<long long, multiset<long long, greater<long long> > > mapa;
    for (long long J = 0; J < k; J++) {
      long long c, d;
      cin >> c >> d;
      mapa[c].insert(d);
    }
    auto it = mapa[1].begin();
    if (it != mapa[1].end()) {
      turnos[I][0].push_back(*it);
      it++;
    }
    if (it != mapa[1].end()) {
      turnos[I][0].push_back(*it);
      it++;
    }
    if (it != mapa[1].end()) {
      turnos[I][0].push_back(*it);
    }
    it = mapa[2].begin();
    if (it != mapa[2].end()) {
      turnos[I][1].push_back(*it);
    }
    it = mapa[3].begin();
    if (it != mapa[3].end()) {
      turnos[I][2].push_back(*it);
    }
  }
  memset(dp, -1, sizeof(dp));
  cout << solve(0, 0) << '\n';
  return 0;
}
