#include <bits/stdc++.h>
using namespace std;
const int N = 100005;
const int INF = (1 << 29);
const int mod = 1000007;
int a, b, c, d, e, f, g, h, i, j, k;
pair<int, int> G[N];
vector<long long> hav[2][1000025];
vector<int> GG[N], Big;
int tot, type[N];
int max_x = -INF, max_y = -INF, min_x = INF, min_y = INF;
int an;
inline long long Num(int x, int y) {
  return 2000000LL * ((long long)x + 2000000 - 1) + ((long long)y + 2000000);
}
inline bool Hash(vector<long long> uu[], int x, int y) {
  long long tt = Num(x, y);
  for (int ii = 0; ii < uu[tt % mod].size(); ii++)
    if (uu[tt % mod][ii] == tt) return true;
  return false;
}
inline void Check1(int x, int y) {
  int delta = G[y].second - G[x].second;
  if (G[x].first - delta >= min_x &&
      Hash(hav[0], G[x].first - delta, G[x].second) &&
      Hash(hav[0], G[x].first - delta, G[y].second))
    an++;
  if (G[x].first - delta >= min_x &&
      Hash(hav[1], G[x].first - delta, G[x].second) &&
      Hash(hav[1], G[x].first - delta, G[y].second))
    an++;
  if (G[x].first + delta <= max_x &&
      Hash(hav[1], G[x].first + delta, G[x].second) &&
      Hash(hav[1], G[x].first + delta, G[y].second))
    an++;
}
inline void Check2(int x, int y) {
  int delta = G[y].first - G[x].first;
  if (G[x].second - delta >= min_y &&
      Hash(hav[1], G[x].first, G[x].second - delta) &&
      Hash(hav[1], G[y].first, G[y].second - delta))
    an++;
}
int main() {
  cin >> a;
  for (i = 1; i <= a; i++) {
    scanf("%d%d", &G[i].first, &G[i].second);
    max_x = max(max_x, G[i].first);
    max_y = max(max_y, G[i].second);
    min_x = min(min_x, G[i].first);
    min_y = min(min_y, G[i].second);
  }
  sort(G + 1, G + a + 1);
  for (i = 1; i <= a; i++) {
    if (i == 1 || G[i].first != G[i - 1].first) tot++;
    GG[tot].push_back(i);
  }
  int siz = (int)sqrt((double)a);
  for (i = 1; i <= tot; i++) {
    int vv = 1;
    if (GG[i].size() <= siz)
      vv = 0;
    else
      Big.push_back(i);
    for (j = 0; j < GG[i].size(); j++) {
      long long tt = Num(G[GG[i][j]].first, G[GG[i][j]].second);
      hav[vv][tt % mod].push_back(tt);
    }
  }
  int Cnt = 0;
  for (i = 1; i <= tot; i++)
    if (GG[i].size() <= siz) {
      Cnt += GG[i].size() * GG[i].size();
      for (j = 0; j < GG[i].size(); j++)
        for (k = j + 1; k < GG[i].size(); k++) Check1(GG[i][j], GG[i][k]);
    }
  for (i = 0; i < Big.size(); i++)
    for (j = i + 1; j < Big.size(); j++) {
      c = Big[i], d = Big[j];
      vector<pair<int, int> > u;
      for (k = 0; k < GG[d].size(); k++)
        u.push_back(make_pair(G[GG[d][k]].second, GG[d][k]));
      int pos = 0;
      for (k = 0; k < GG[c].size(); k++) {
        while (pos < u.size() && G[GG[c][k]].second > u[pos].first) pos++;
        if (pos == u.size()) break;
        if (G[GG[c][k]].second < u[pos].first) continue;
        Check2(GG[c][k], u[pos].second);
      }
    }
  cout << an << endl;
  return 0;
}
