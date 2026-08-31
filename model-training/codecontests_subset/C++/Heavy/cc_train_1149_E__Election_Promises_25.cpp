#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 5;
vector<int> ve1[maxn], ve2[maxn];
int rd[maxn];
int n, m;
int sm[maxn], h[maxn];
queue<int> q;
int mx[maxn];
int vis[maxn];
vector<int> veo[maxn];
bool mark[maxn];
void ptans() {
  for (int i = 1; i <= n; i++) {
    printf("%d ", h[i]);
  }
}
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &h[i]);
  }
  for (int i = 1; i <= m; i++) {
    int x, y;
    scanf("%d%d", &x, &y);
    ve1[x].push_back(y);
    ve2[y].push_back(x);
    rd[x]++;
  }
  for (int i = 1; i <= n; i++) {
    if (!rd[i]) q.push(i);
  }
  while (q.size()) {
    int x = q.front();
    q.pop();
    for (auto y : ve1[x]) {
      vis[mx[y]] = x;
    }
    for (auto y : ve2[x]) {
      if (--rd[y] == 0) q.push(y);
    }
    for (mx[x] = 0; vis[mx[x]] == x; ++mx[x])
      ;
  }
  for (int i = 1; i <= n; i++) {
    sm[mx[i]] ^= h[i];
    veo[mx[i]].push_back(i);
  }
  for (int p = n; p >= 0; --p) {
    if (sm[p]) {
      puts("WIN");
      for (auto x : veo[p]) {
        if ((h[x] ^ sm[p]) < h[x]) {
          h[x] ^= sm[p];
          for (auto y : ve1[x]) {
            if (mark[mx[y]]) continue;
            mark[mx[y]] = 1;
            h[y] ^= sm[mx[y]];
          }
          ptans();
          return 0;
        }
      }
    }
  }
  puts("LOSE");
}
