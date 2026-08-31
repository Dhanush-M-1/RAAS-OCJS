#include <bits/stdc++.h>
using namespace std;
int read(int &x) { return scanf("%d", &x); }
int read(int &x, int &y) { return scanf("%d%d", &x, &y); }
int read(int &x, int &y, int &z) { return scanf("%d%d%d", &x, &y, &z); }
int read(long long &x) { return scanf("%lld", &x); }
int read(long long &x, long long &y) { return scanf("%lld%lld", &x, &y); }
int read(double &x) { return scanf("%lf", &x); }
char buff[2000010];
int read(string &s) {
  int r = scanf("%s", buff);
  s = buff;
  return r;
}
using namespace std;
struct Groups {
  set<pair<long long, long long> > G[10];
  long long S[10];
  Groups() {
    for (int i = 0; i < 10; ++i) S[i] = 0;
  }
  pair<long long, long long> add(int type, pair<long long, long long> p) {
    G[type].insert(p);
    S[type] += p.first;
    return p;
  }
  pair<long long, long long> rem(int type, pair<long long, long long> p) {
    G[type].erase(p);
    S[type] -= p.first;
    return p;
  }
  long long sum(int type) { return S[type]; }
  int size(int type) { return G[type].size(); }
  pair<long long, long long> getLower(int type) { return *G[type].begin(); }
  pair<long long, long long> getHigher(int type) { return *G[type].rbegin(); }
  bool contains(int type, pair<long long, long long> v) {
    return G[type].count(v) > 0;
  }
  pair<long long, long long> moveLower(int typeSource, int typeDest) {
    auto v = getLower(typeSource);
    rem(typeSource, v);
    add(typeDest, v);
    return v;
  }
  pair<long long, long long> moveHigher(int typeSource, int typeDest) {
    auto v = getHigher(typeSource);
    rem(typeSource, v);
    add(typeDest, v);
    return v;
  }
};
int main() {
  int TC = 1;
  while (TC-- > 0) {
    int N, M, K;
    read(N, M, K);
    Groups G;
    vector<int> O(N);
    for (int i = 0; i < N; ++i) {
      int n, a, b;
      read(n, a, b);
      O[i] = n;
      if (a && b)
        G.add(3, pair<long long, long long>(n, i));
      else if (a)
        G.add(1, pair<long long, long long>(n, i));
      else if (b)
        G.add(2, pair<long long, long long>(n, i));
      else
        G.add(4, pair<long long, long long>(n, i));
    }
    int bi = -1;
    long long bs = -1;
    int both = G.size(3);
    auto adjustGroup = [&](int type, int graveyard, int target, bool updateD) {
      while (G.size(type) > 0 && G.size(graveyard) > 0 &&
             G.getHigher(type) > G.getLower(graveyard)) {
        G.moveHigher(type, graveyard);
      }
      while (G.size(type) > target && G.size(type) > 0) {
        auto v = G.moveHigher(type, graveyard);
        if (updateD) {
          G.add(4, v);
        }
      }
      while (G.size(type) < target && G.size(graveyard) > 0) {
        auto v = G.moveLower(graveyard, type);
        if (updateD) {
          int pos = G.contains(4, v) ? 4 : 6;
          G.rem(pos, v);
        }
      }
    };
    auto adjustGroups = [&](int toBoth) {
      int needFromAlone = max(0, K - toBoth);
      int extras = max(0, M - toBoth - 2 * needFromAlone);
      adjustGroup(3, 5, toBoth, true);
      adjustGroup(1, 8, needFromAlone, true);
      adjustGroup(2, 7, needFromAlone, true);
      adjustGroup(4, 6, extras, false);
    };
    for (int i = 0; i <= both; ++i) {
      int needFromAlone = max(0, K - i);
      int extras = max(0, M - i - 2 * needFromAlone);
      if (extras + 2 * needFromAlone + i != M) continue;
      adjustGroups(i);
      if (G.size(3) == i && G.size(1) == needFromAlone &&
          G.size(2) == needFromAlone && G.size(4) == extras) {
        long long ns = G.sum(3) + G.sum(1) + G.sum(2) + G.sum(4);
        if (bi == -1 || bs > ns) {
          bi = i;
          bs = ns;
        }
      }
    }
    cout << bs << endl;
    if (bs != -1) {
      adjustGroups(bi);
      int needFromAlone = max(0, K - bi);
      int extras = max(0, M - bi - 2 * needFromAlone);
      vector<int> I;
      assert(G.size(3) == bi && G.size(1) == needFromAlone &&
             G.size(2) == needFromAlone && G.size(4) == extras);
      for (auto p : G.G[3]) I.push_back(p.second);
      for (auto p : G.G[1]) I.push_back(p.second);
      for (auto p : G.G[2]) I.push_back(p.second);
      for (auto p : G.G[4]) I.push_back(p.second);
      sort(I.begin(), I.end());
      for (int v : I) cout << v + 1 << " ";
      cout << endl;
    }
  }
}
