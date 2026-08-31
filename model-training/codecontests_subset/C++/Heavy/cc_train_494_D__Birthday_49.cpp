#include <bits/stdc++.h>
using namespace std;
const int MOD = 1000000007;
int N, Q;
vector<pair<int, int> > V[100002];
vector<int> W[100002];
int Q1[100002], Q2[100002];
bool S[100002];
int in[100002], out[100002], nods[100002], tn;
int D[100002];
int SUM[4 * 100002], ARB[4 * 100002], ADD[4 * 100002], A1, A2, As;
int result[100002];
void setall(int nod, int i1, int i2) {
  if (i1 == i2) {
    SUM[nod] = D[nods[i1]];
    ARB[nod] = ((long long)D[nods[i1]]) * D[nods[i1]] % MOD;
    return;
  }
  int mid = (i1 + i2) / 2;
  setall(nod * 2, i1, mid);
  setall(nod * 2 + 1, mid + 1, i2);
  ARB[nod] = (ARB[nod * 2] + ARB[nod * 2 + 1]) % MOD;
  SUM[nod] = (SUM[nod * 2] + SUM[nod * 2 + 1]) % MOD;
}
void renew(int nod, int i1, int i2) {
  ARB[nod] += ((long long)ADD[nod]) * ADD[nod] % MOD * (i2 - i1 + 1) % MOD;
  if (ARB[nod] >= MOD) ARB[nod] -= MOD;
  ARB[nod] += ((long long)ADD[nod]) * SUM[nod] * 2 % MOD;
  if (ARB[nod] >= MOD) ARB[nod] -= MOD;
  SUM[nod] += ((long long)ADD[nod]) * (i2 - i1 + 1) % MOD;
  if (SUM[nod] >= MOD) SUM[nod] -= MOD;
  if (i1 != i2) {
    ADD[nod * 2] += ADD[nod];
    if (ADD[nod * 2] >= MOD) ADD[nod * 2] -= MOD;
    ADD[nod * 2 + 1] += ADD[nod];
    if (ADD[nod * 2 + 1] >= MOD) ADD[nod * 2 + 1] -= MOD;
  }
  ADD[nod] = 0;
}
void update(int nod, int i1, int i2) {
  if (A1 <= i1 && i2 <= A2) {
    ADD[nod] += As;
    if (ADD[nod] >= MOD) ADD[nod] -= MOD;
    return;
  }
  if (ADD[nod] != 0) renew(nod, i1, i2);
  int mid = (i1 + i2) / 2;
  if (A1 <= mid) update(nod * 2, i1, mid);
  if (A2 > mid) update(nod * 2 + 1, mid + 1, i2);
  renew(nod * 2, i1, mid);
  renew(nod * 2 + 1, mid + 1, i2);
  ARB[nod] = (ARB[nod * 2] + ARB[nod * 2 + 1]) % MOD;
  SUM[nod] = (SUM[nod * 2] + SUM[nod * 2 + 1]) % MOD;
}
void query(int nod, int i1, int i2) {
  if (ADD[nod] != 0) renew(nod, i1, i2);
  if (A1 <= i1 && i2 <= A2) {
    As += ARB[nod];
    if (As >= MOD) As -= MOD;
    return;
  }
  int mid = (i1 + i2) / 2;
  if (A1 <= mid) query(nod * 2, i1, mid);
  if (A2 > mid) query(nod * 2 + 1, mid + 1, i2);
}
void Dfs(int x) {
  S[x] = true;
  in[x] = ++tn;
  nods[tn] = x;
  for (auto nod : V[x])
    if (!S[nod.first]) {
      D[nod.first] = (D[x] + nod.second) % MOD;
      Dfs(nod.first);
    }
  out[x] = tn;
}
void Prop(int x) {
  S[x] = true;
  for (auto qn : W[x]) {
    A1 = 1, A2 = N, As = 0;
    query(1, 1, N);
    result[qn] = (MOD - As) % MOD;
    A1 = in[Q2[qn]], A2 = out[Q2[qn]], As = 0;
    query(1, 1, N);
    As = 2 * As % MOD;
    result[qn] += As;
    if (result[qn] >= MOD) result[qn] -= MOD;
  }
  for (auto nod : V[x])
    if (!S[nod.first]) {
      A1 = 1, A2 = N, As = nod.second;
      update(1, 1, N);
      A1 = in[nod.first], A2 = out[nod.first],
      As = (2 * MOD - 2 * nod.second) % MOD;
      update(1, 1, N);
      Prop(nod.first);
      A1 = 1, A2 = N, As = (MOD - nod.second) % MOD;
      update(1, 1, N);
      A1 = in[nod.first], A2 = out[nod.first], As = 2 * nod.second % MOD;
      update(1, 1, N);
    }
}
int main() {
  cin.sync_with_stdio(false);
  cin >> N;
  for (int i = 1, nod1, nod2, val; i <= N - 1; ++i) {
    cin >> nod1 >> nod2 >> val;
    V[nod1].push_back(make_pair(nod2, val));
    V[nod2].push_back(make_pair(nod1, val));
  }
  cin >> Q;
  for (int i = 1; i <= Q; ++i) {
    cin >> Q1[i] >> Q2[i];
    W[Q1[i]].push_back(i);
  }
  Dfs(1);
  setall(1, 1, N);
  memset(S, 0, sizeof(S));
  Prop(1);
  for (int i = 1; i <= Q; ++i) cout << result[i] << '\n';
}
