#include <bits/stdc++.h>
using namespace std;
long long rdtsc() {
  long long tmp;
  asm("rdtsc" : "=A"(tmp));
  return tmp;
}
inline int myrand() { return abs((rand() << 15) ^ rand()); }
inline int rnd(int x) { return myrand() % x; }
const int INF = (int)1e9 + 1;
const long double EPS = 1e-9;
const int MOD = (int)1e9 + 7;
void add(int &x, int y) {
  if ((x += y) >= MOD) {
    x -= MOD;
  }
}
int mult(int x, int y) { return (long long)x * y % MOD; }
const int maxn = 50 + 5;
int go[maxn][maxn], ids[maxn][maxn];
const int maxm = maxn * (maxn - 1) / 2;
vector<int> inside[maxm];
bool check(int rev, vector<int> &cur, int maxLen) {
  for (int i = 0; i < ((int)(cur).size()) - 1 && ((int)(cur).size()) <= maxLen;
       ++i) {
    int s = cur[i], t = cur[i + 1];
    if (rev) {
      swap(s, t);
    }
    if (!go[s][t]) {
      return 0;
    }
    int id = ids[s][t];
    for (int pos = 0;
         pos < ((int)(inside[id]).size()) && ((int)(cur).size()) <= maxLen;
         ++pos) {
      cur.push_back(
          inside[id][rev ? (((int)(inside[id]).size()) - 1 - pos) : pos]);
    }
  }
  return ((int)(cur).size()) <= maxLen;
}
const int maxl = 2 * maxn + 1;
struct Piece {
  int first, last;
  int len;
  Piece() {}
  Piece(int _first, int _last, int _len)
      : first(_first), last(_last), len(_len) {}
};
int maxLen;
int d[maxl][2][maxn];
int ans[maxl];
void addVector(const vector<Piece> &pieces, int ntype, int len, int type, int v,
               int value) {
  for (const Piece &p : pieces) {
    if (p.first != v) {
      continue;
    }
    int nlen = len + p.len;
    if (nlen > maxLen) {
      continue;
    }
    add(d[nlen][ntype][p.last], value);
  }
}
bool solve() {
  int n, m;
  if (scanf("%d%d", &n, &m) < 2) {
    return 0;
  }
  assert(n <= maxn && m <= maxm);
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < n; ++j) {
      go[i][j] = 0, ids[i][j] = -1;
    }
  }
  for (int i = 0; i < m; ++i) {
    int s, t, k;
    scanf("%d%d%d", &s, &t, &k);
    --s, --t;
    go[s][t] = 1;
    ids[s][t] = i;
    inside[i].resize(k);
    for (int j = 0; j < k; ++j) {
      scanf("%d", &inside[i][j]);
      --inside[i][j];
    }
  }
  maxLen = 2 * n;
  vector<Piece> lefts, rights, mids, spaces;
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < n; ++j) {
      if (!go[i][j]) {
        continue;
      }
      int id = ids[i][j];
      if (((int)(inside[id]).size())) {
        continue;
      }
      spaces.push_back(Piece(i, j, 1));
    }
  }
  for (int rev = 0; rev < 2; ++rev) {
    for (int v = 0; v < n; ++v) {
      for (int t = 0; t < n; ++t) {
        int a = v, b = t;
        if (rev) {
          swap(a, b);
        }
        if (go[a][b] == 0) {
          continue;
        }
        int id = ids[a][b];
        if (((int)(inside[id]).size()) > maxLen ||
            ((int)(inside[id]).size()) == 0) {
          continue;
        }
        vector<int> vis = inside[id];
        if (rev) {
          reverse(vis.begin(), vis.end());
        }
        if (vis[0] != t) {
          continue;
        }
        if (check(rev, vis, maxLen)) {
          Piece toadd(v, vis[((int)(vis).size()) - 1], ((int)(vis).size()));
          if (rev) {
            swap(toadd.first, toadd.last);
          }
          (!rev ? rights : lefts).push_back(toadd);
        }
      }
    }
  }
  for (int s = 0; s < n; ++s) {
    for (int t = 0; t < n; ++t) {
      if (!go[s][t]) {
        continue;
      }
      int id = ids[s][t];
      for (int pos = 0; pos < ((int)(inside[id]).size()) - 1; ++pos) {
        if (inside[id][pos] != s || inside[id][pos + 1] != t) {
          continue;
        }
        vector<int> cur;
        for (int j = pos + 1; j < ((int)(inside[id]).size()); ++j) {
          cur.push_back(inside[id][j]);
        }
        if (check(0, cur, maxLen - pos - 1)) {
          vector<int> right = cur;
          cur.clear();
          for (int j = pos; j >= 0; --j) {
            cur.push_back(inside[id][j]);
          }
          if (check(1, cur, maxLen - ((int)(right).size()))) {
            reverse(cur.begin(), cur.end());
            mids.push_back(
                Piece(cur[0], right[((int)(right).size()) - 1],
                      ((int)(cur).size()) + ((int)(right).size()) - 1));
          }
        }
      }
    }
  }
  for (int i = 0; i <= maxLen; ++i) {
    ans[i] = 0;
    for (int type = 0; type < 2; ++type) {
      for (int v = 0; v < n; ++v) {
        d[i][type][v] = 0;
      }
    }
  }
  for (int v = 0; v < n; ++v) {
    d[0][0][v] = 1;
  }
  for (int len = 0; len <= maxLen; ++len) {
    for (int type = 0; type < 2; ++type) {
      for (int v = 0; v < n; ++v) {
        int &cur = d[len][type][v];
        if (cur == 0) {
          continue;
        }
        if (type == 1) {
          add(ans[len], cur);
        }
        if (type == 0) {
          addVector(lefts, 0, len, type, v, cur);
          addVector(mids, 1, len, type, v, cur);
        }
        if (type == 1) {
          addVector(rights, 1, len, type, v, cur);
          addVector(spaces, 0, len, type, v, cur);
        }
      }
    }
  }
  for (int i = 1; i <= maxLen; ++i) {
    printf("%d\n", ans[i]);
  }
  return 1;
}
int main() {
  srand(rdtsc());
  while (1) {
    if (!solve()) break;
  }
  return 0;
}
