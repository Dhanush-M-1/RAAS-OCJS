#include <bits/stdc++.h>
using namespace std;
const int mod = 1000000007;
inline int add(int a, int b) {
  if ((a += b) >= mod) a -= mod;
  return a;
}
inline void _add(int &a, int b) {
  if ((a += b) >= mod) a -= mod;
}
inline int mult(int a, int b) {
  long long t = 1ll * a * b;
  if (t >= mod) t %= mod;
  return t;
}
int n, m;
bool f[52][52];
vector<int> E[52][52];
int typA_[52][52][102], typA_C[52][52][102], typA_CB_[52][52][102],
    typZA_CB_[52][52][102], ans[52][102];
vector<int> typA[52][52], typB[52][52], typC[52][52];
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1, s, e, K; i <= m; i++) {
    scanf("%d%d%d", &s, &e, &K);
    f[s][e] = 1;
    E[s][e].resize(K);
    for (int j = 0; j < K; j++) scanf("%d", &E[s][e][j]);
  }
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
      for (int k = 0; k + 1 < E[i][j].size(); k++) {
        if (E[i][j][k] == i && E[i][j][k + 1] == j) {
          vector<int> cur = E[i][j], tmp;
          while (1) {
            if (cur.size() > 2 * n + 1) break;
            bool flag = 0;
            tmp.clear();
            for (int t = 0; t + 1 < cur.size(); t++) {
              if (!f[cur[t]][cur[t + 1]]) {
                flag = 1;
                break;
              }
              tmp.insert(tmp.end(), E[cur[t]][cur[t + 1]].begin(),
                         E[cur[t]][cur[t + 1]].end());
            }
            if (flag) break;
            if (tmp == cur) {
              typC[cur[0]][cur.back()].push_back(cur.size() - 1);
              break;
            }
            if (tmp.size() > 2 * n + 1) break;
            swap(tmp, cur);
          }
          break;
        }
      }
    }
  }
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
      if (E[i][j].size() && E[i][j].back() == i) {
        vector<int> cur({i}), tmp;
        while (1) {
          if (cur.size() > 2 * n) break;
          bool flag = 0;
          tmp = E[cur[0]][j];
          reverse(tmp.begin(), tmp.end());
          for (int t = 0; t + 1 < cur.size(); t++) {
            if (!f[cur[t + 1]][cur[t]]) {
              flag = 1;
              break;
            }
            reverse(E[cur[t + 1]][cur[t]].begin(), E[cur[t + 1]][cur[t]].end());
            tmp.insert(tmp.end(), E[cur[t + 1]][cur[t]].begin(),
                       E[cur[t + 1]][cur[t]].end());
            reverse(E[cur[t + 1]][cur[t]].begin(), E[cur[t + 1]][cur[t]].end());
          }
          if (flag) break;
          if (tmp == cur) {
            typA[cur.back()][j].push_back(cur.size());
            break;
          }
          if (tmp.size() > 2 * n) break;
          cur = tmp;
        }
      }
    }
  }
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
      if (E[i][j].size() && E[i][j][0] == j) {
        vector<int> cur({j}), tmp;
        while (1) {
          if (cur.size() > 2 * n) break;
          bool flag = 0;
          tmp = E[i][cur[0]];
          for (int t = 0; t + 1 < cur.size(); t++) {
            if (!f[cur[t]][cur[t + 1]]) {
              flag = 1;
              break;
            }
            tmp.insert(tmp.end(), E[cur[t]][cur[t + 1]].begin(),
                       E[cur[t]][cur[t + 1]].end());
          }
          if (flag) break;
          if (tmp == cur) {
            typB[i][cur.back()].push_back(cur.size());
            break;
          }
          if (tmp.size() > 2 * n) break;
          cur = tmp;
        }
      }
    }
  }
  for (int i = 1; i <= n; i++) typA_[i][i][0] = 1;
  for (int len = 0; len <= 2 * n; len++) {
    for (int s = 1; s <= n; s++) {
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
          for (int &x : typA[i][j])
            if (x + len <= 2 * n) _add(typA_[s][j][len + x], typA_[s][i][len]);
        }
      }
    }
  }
  for (int s = 1; s <= n; s++) {
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        for (int len = 0; len <= 2 * n; len++) {
          for (int &x : typC[i][j])
            if (x + len <= 2 * n) _add(typA_C[s][j][len + x], typA_[s][i][len]);
        }
      }
    }
  }
  memcpy(typA_CB_, typA_C, sizeof(typA_C));
  for (int len = 0; len <= 2 * n; len++) {
    for (int s = 1; s <= n; s++) {
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
          for (int &x : typB[i][j])
            if (x + len <= 2 * n)
              _add(typA_CB_[s][j][len + x], typA_CB_[s][i][len]);
        }
      }
    }
  }
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
      if (f[i][j] && !E[i][j].size()) {
        for (int k = 1; k <= n; k++) {
          for (int l = 0; l + 1 <= 2 * n; l++) {
            _add(typZA_CB_[i][k][l + 1], typA_CB_[j][k][l]);
          }
        }
      }
    }
  }
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
      for (int l = 1; l <= 2 * n; l++) _add(ans[j][l], typA_CB_[i][j][l]);
    }
  }
  for (int l = 1; l <= 2 * n; l++) {
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        for (int l1 = 1; l1 + l <= 2 * n; l1++) {
          _add(ans[j][l + l1], mult(ans[i][l], typZA_CB_[i][j][l1]));
        }
      }
    }
  }
  for (int i = 1; i <= n * 2; i++) {
    int s = 0;
    for (int j = 1; j <= n; j++) _add(s, ans[j][i]);
    printf("%d\n", s);
  }
  return 0;
}
