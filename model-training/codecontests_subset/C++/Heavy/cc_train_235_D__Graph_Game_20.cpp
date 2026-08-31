#include <bits/stdc++.h>
using namespace std;
template <class T>
inline T min(T &a, T &b) {
  return a < b ? a : b;
}
template <class T>
inline T max(T &a, T &b) {
  return a > b ? a : b;
}
template <class T>
void read(T &x) {
  char ch;
  while ((ch = getchar()) && !isdigit(ch))
    ;
  x = ch - '0';
  while ((ch = getchar()) && isdigit(ch)) x = x * 10 + ch - '0';
}
long long Pow(long long a, long long b, long long Mod) {
  long long ans = 1;
  a %= Mod;
  for (; b; b >>= 1) ans = b & 1 ? (ans * a % Mod) : ans, a = a * a % Mod;
  return ans;
}
const int N = 3010;
queue<int> Q;
vector<int> E[N];
int n, Tree[N], dis[N], vis[N], rd[N], Ring[N], Rcnt;
double Ans[N][N];
void dfs(int w, int Fa, int id) {
  if (Fa) Tree[w] = id;
  for (int i = 0; i < E[w].size(); i++)
    if (!Ring[E[w][i]] && E[w][i] != Fa) dfs(E[w][i], w, id);
}
void spfa(int S) {
  for (int i = 1; i <= n; i++) dis[i] = int(1e8), vis[i] = 0;
  dis[S] = 1;
  Q.push(S);
  while (Q.size()) {
    int x = Q.front();
    Q.pop();
    vis[x] = 0;
    for (int i = 0; i < E[x].size(); i++)
      if (dis[E[x][i]] > dis[x] + 1) {
        dis[E[x][i]] = dis[x] + 1;
        if (!vis[E[x][i]]) Q.push(E[x][i]), vis[E[x][i]] = 1;
      }
  }
}
int Dis_Min(int x, int y) {
  if (x > y) swap(x, y);
  return min(y - x + 1, Rcnt - y + 1 + x);
}
int Dis_Max(int x, int y) {
  if (x > y) swap(x, y);
  return max(y - x + 1, Rcnt - y + 1 + x);
}
int main() {
  scanf("%d", &n);
  int x, y;
  for (int i = 1; i <= n; i++)
    scanf("%d%d", &x, &y), x++, y++, rd[x]++, rd[y]++, E[x].push_back(y),
        E[y].push_back(x);
  for (int i = 1; i <= n; i++)
    if (rd[i] == 1) Q.push(i);
  while (Q.size()) {
    int x = Q.front();
    Q.pop();
    Tree[x] = 1;
    for (int i = 0; i < E[x].size(); i++) {
      rd[E[x][i]]--;
      if (rd[E[x][i]] == 1) Q.push(E[x][i]);
    }
  }
  int R1 = 0, Rn;
  for (int i = 1; i <= n; i++)
    if (!Tree[i]) {
      R1 = i;
      Ring[i] = ++Rcnt;
      break;
    }
  Rn = R1;
  while (1) {
    int flag = 0;
    for (int i = 0; i < E[Rn].size(); i++)
      if (!Tree[E[Rn][i]] && !Ring[E[Rn][i]]) {
        flag = 1;
        Ring[E[Rn][i]] = ++Rcnt;
        Rn = E[Rn][i];
        break;
      }
    if (!flag) break;
  }
  for (int i = 1; i <= n; i++)
    if (!Tree[i]) dfs(i, 0, i);
  double ans = n;
  for (int i = 1; i <= n; i++) {
    spfa(i);
    for (int j = 1; j <= n; j++)
      if (j != i) {
        double aans = ans;
        if ((Tree[i] && Tree[i] == Tree[j]) || (Tree[i] == j) || (Tree[j] == i))
          ans += 1. / dis[j];
        else {
          if (Ring[i] && Ring[j]) {
            ans += 1. / Dis_Min(Ring[i], Ring[j]) +
                   1. / Dis_Max(Ring[i], Ring[j]) - 1. / Rcnt;
          } else if (Ring[i]) {
            ans += 1. / dis[j];
            ans += 1. / (dis[j] - Dis_Min(Ring[i], Ring[Tree[j]]) +
                         Dis_Max(Ring[i], Ring[Tree[j]]));
            ans -= 1. / (dis[j] - Dis_Min(Ring[i], Ring[Tree[j]]) + Rcnt);
          } else if (Ring[j]) {
            ans += 1. / dis[j];
            ans += 1. / (dis[j] - Dis_Min(Ring[j], Ring[Tree[i]]) +
                         Dis_Max(Ring[j], Ring[Tree[i]]));
            ans -= 1. / (dis[j] - Dis_Min(Ring[j], Ring[Tree[i]]) + Rcnt);
          } else {
            ans += 1. / dis[j];
            ans += 1. / (dis[j] - Dis_Min(Ring[Tree[j]], Ring[Tree[i]]) +
                         Dis_Max(Ring[Tree[j]], Ring[Tree[i]]));
            ans -= 1. / (dis[j] - Dis_Min(Ring[Tree[j]], Ring[Tree[i]]) + Rcnt);
          }
        }
        Ans[i][j] = ans - aans;
      }
  }
  printf("%.10lf\n", ans);
}
