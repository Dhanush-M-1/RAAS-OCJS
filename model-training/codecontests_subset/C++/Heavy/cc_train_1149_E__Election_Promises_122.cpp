#include <bits/stdc++.h>
using namespace std;
const int MAX = (int)2e5 + 5;
int n, m;
vector<int> v[MAX];
int h[MAX];
set<int> s[MAX];
set<int> t[MAX];
int dep[MAX];
int xors[MAX];
vector<pair<int, int> > mxx[MAX];
int bio[MAX];
int p[1000];
void dfs(int cx) {
  if (bio[cx]) return;
  bio[cx] = 1;
  for (int i = (0), _for = (1000); i < _for; ++i) p[i] = 0;
  for (auto first : v[cx]) {
    p[dep[first]] = 1;
  }
  for (int i = (0), _for = (1000); i < _for; ++i) {
    if (!p[i]) {
      dep[cx] = i;
      xors[i] ^= h[cx];
      mxx[i].push_back({h[cx], cx});
      break;
    }
  }
  for (auto nx : t[cx]) {
    s[nx].erase(cx);
    if (s[nx].empty()) dfs(nx);
  }
}
int find_cx(int i) {
  int xr = xors[i];
  for (auto cx : mxx[i]) {
    if ((cx.first ^ xr) <= cx.first) return cx.second;
  }
  return -1;
}
int main() {
  scanf("%d%d", &n, &m);
  for (int i = (0), _for = (n); i < _for; ++i) scanf("%d", h + i);
  for (int i = (0), _for = (m); i < _for; ++i) {
    int a, b;
    scanf("%d%d", &a, &b);
    a--;
    b--;
    v[a].push_back(b);
    s[a].insert(b);
    t[b].insert(a);
  }
  for (int i = (0), _for = (n); i < _for; ++i)
    if (s[i].empty()) dfs(i);
  for (int i = 999; i >= 0; --i)
    if (xors[i]) {
      puts("WIN");
      int cx = find_cx(i);
      h[cx] ^= xors[i];
      for (auto nx : v[cx]) {
        int d = dep[nx];
        h[nx] ^= xors[d];
        xors[d] = 0;
      }
      for (int i = (0), _for = (n); i < _for; ++i) {
        printf("%d ", h[i]);
      }
      printf("\n");
      return 0;
    }
  puts("LOSE");
  return 0;
}
