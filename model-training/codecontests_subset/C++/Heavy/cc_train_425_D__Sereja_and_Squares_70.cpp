#include <bits/stdc++.h>
using namespace std;
const int inft = 1000000009;
const int MAXN = 1000006;
pair<int, int> P[MAXN];
int n;
vector<pair<int, int> > X[MAXN], Y[MAXN];
inline bool czy(pair<int, int> a) {
  if (min(a.first, a.second) < 0 || max(a.first, a.second) >= MAXN) return 0;
  if (X[a.first].size() < Y[a.second].size())
    return binary_search((X[a.first]).begin(), (X[a.first]).end(), a);
  else
    return binary_search((Y[a.second]).begin(), (Y[a.second]).end(), a);
}
inline bool jest(pair<int, int> a, int d) {
  return czy(pair<int, int>(a.first - d, a.second)) &&
         czy(pair<int, int>(a.first - d, a.second - d)) &&
         czy(pair<int, int>(a.first, a.second - d));
}
int main() {
  scanf("%d", &n);
  for (int i = 0; i < (n); ++i) scanf("%d%d", &P[i].first, &P[i].second);
  sort(P, P + n);
  for (int i = 0; i < (n); ++i) X[P[i].first].push_back(P[i]);
  for (int i = 0; i < (n); ++i) Y[P[i].second].push_back(P[i]);
  for (int i = 0; i < (MAXN); ++i) sort((X[i]).begin(), (X[i]).end());
  for (int i = 0; i < (MAXN); ++i) sort((Y[i]).begin(), (Y[i]).end());
  int ret = 0;
  for (int i = 0; i < (n); ++i) {
    int first = P[i].first, second = P[i].second;
    int x1 = lower_bound((X[first]).begin(), (X[first]).end(), P[i]) -
             X[first].begin();
    int y1 = lower_bound((Y[second]).begin(), (Y[second]).end(), P[i]) -
             Y[second].begin();
    if (x1 <= y1)
      for (int j = 0; j < (x1); ++j)
        ret += jest(P[i], P[i].second - X[first][j].second);
    else
      for (int j = 0; j < (y1); ++j)
        ret += jest(P[i], P[i].first - Y[second][j].first);
  }
  printf("%d\n", ret);
  return 0;
}
