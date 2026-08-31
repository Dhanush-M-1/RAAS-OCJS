#include <bits/stdc++.h>
using namespace std;
int n, m, k;
set<pair<int, int>> S;
vector<int> A;
vector<pair<int, int>> R;
vector<vector<int>> G;
set<pair<int, int>> B;
int main() {
  cin >> n >> m >> k;
  R.assign(m, {0, 0});
  A.assign(n, 0);
  G.assign(n, vector<int>(0, 0));
  for (auto &i : R) {
    cin >> i.first >> i.second;
    i.first--;
    i.second--;
    G[i.first].push_back(i.second);
    G[i.second].push_back(i.first);
    A[i.first]++;
    A[i.second]++;
  }
  for (int i = 0; i < n; i++) {
    S.insert({A[i], i});
  }
  while (S.size() && (*S.begin()).first < k) {
    int x = (*S.begin()).second;
    S.erase(S.begin());
    for (int y : G[x]) {
      if (A[y] == -1) continue;
      S.erase(S.find({A[y], y}));
      A[y]--;
      S.insert({A[y], y});
    }
    A[x] = -1;
  }
  vector<int> Ans(m, 0);
  for (int i = m - 1; i >= 0; i--) {
    Ans[i] = S.size();
    int x, y;
    x = R[i].first;
    y = R[i].second;
    B.insert({x, y});
    B.insert({y, x});
    if (A[x] != -1 && A[y] != -1) {
      S.erase(S.find({A[x], x}));
      A[x]--;
      S.insert({A[x], x});
      S.erase(S.find({A[y], y}));
      A[y]--;
      S.insert({A[y], y});
    }
    while (!S.empty() && (*S.begin()).first < k) {
      int X = (*S.begin()).second;
      S.erase(S.begin());
      for (int Y : G[X]) {
        if (A[Y] == -1 || B.count({X, Y})) continue;
        S.erase(S.find({A[Y], Y}));
        A[Y]--;
        S.insert({A[Y], Y});
      }
      A[X] = -1;
    }
  }
  for (int i : Ans) {
    cout << i << "\n";
  }
}
