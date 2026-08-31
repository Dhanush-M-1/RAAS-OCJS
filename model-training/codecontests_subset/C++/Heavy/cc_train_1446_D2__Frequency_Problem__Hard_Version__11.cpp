#include <bits/stdc++.h>
using namespace std;
vector<int> P[200000];
set<int> M, MM;
vector<pair<int, int>> PP;
int A[200001], V[400001], R[400001];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ((void)0);
  ((void)0);
  ((void)0);
  int N, m = 0, ans = 0;
  cin >> N;
  memset(R, -1, sizeof(R));
  for (int i = 1; i <= N; i++) {
    cin >> A[i];
    P[--A[i]].push_back(i);
  }
  for (int i = 1; i < N; i++)
    if (P[i].size() > P[m].size()) m = i;
  for (auto v : P[m]) M.insert(v);
  for (int v = 0; v < N; v++)
    if (v != m && P[v].size()) {
      int PS = 200000;
      PP.clear();
      PP.emplace_back(0, PS);
      for (auto p : P[v]) {
        auto it = M.lower_bound(p);
        if (it != M.begin()) {
          PP.emplace_back(*--it, 1);
          MM.insert(*it);
          M.erase(it);
          it = M.lower_bound(p);
        }
        if (it != M.begin()) {
          PP.emplace_back(*--it, 1);
          MM.insert(*it);
          M.erase(it);
          it = M.lower_bound(p);
        }
        PP.emplace_back(p, -1);
        if (it != M.end()) {
          PP.emplace_back(*it, 1);
          MM.insert(*it);
          M.erase(it);
          it = M.lower_bound(p);
        }
        if (it != M.end()) {
          PP.emplace_back(*it, 1);
          MM.insert(*it);
          M.erase(it);
        }
      }
      PP.emplace_back(N + 1, 0);
      sort(PP.begin(), PP.end());
      R[PS] = v;
      V[PS] = 0;
      for (int i = 1; i + 1 < PP.size(); i++) {
        PS += PP[i].second;
        if (R[PS] != v) {
          V[PS] = PP[i].first;
          R[PS] = v;
        } else
          ans = max(ans, PP[i + 1].first - V[PS] - 1);
      }
      for (auto v : MM) M.insert(v);
      MM.clear();
    }
  cout << ans << '\n';
  return 0;
}
