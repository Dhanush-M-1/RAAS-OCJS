#include <bits/stdc++.h>
using namespace std;
const int MaxN = 2e5 + 5;
int N, Root;
int Size[MaxN];
bool Vis[MaxN];
vector<int> Son[MaxN];
namespace Input {
const int L = 1 << 20;
char *s, *t, c, buf[L];
char gc() {
  if (s == t) {
    t = (s = buf) + fread(buf, 1, L, stdin);
    if (s == t) return EOF;
  }
  return *s++;
}
void gi(int &x) {
  x = 0;
  while (c = gc(), c < '0' || c > '9')
    ;
  while (c >= '0' && c <= '9') x = x * 10 + c - '0', c = gc();
}
}  // namespace Input
using Input::gi;
void Del(int u) {
  Vis[u] = true;
  printf("%d\n", u);
  int i;
  for (i = 0; i < Son[u].size(); i++)
    if (!Vis[Son[u][i]]) Del(Son[u][i]);
}
void DFS(int u) {
  int i;
  Size[u] = 1;
  for (i = 0; i < Son[u].size(); i++) {
    DFS(Son[u][i]);
    Size[u] += Size[Son[u][i]];
  }
  if (!(Size[u] & 1)) Del(u);
}
int main() {
  int i, fa;
  gi(N);
  if (!(N & 1)) {
    puts("NO");
    return 0;
  }
  puts("YES");
  for (i = 1; i <= N; i++) {
    gi(fa);
    if (fa)
      Son[fa].push_back(i);
    else
      Root = i;
  }
  DFS(Root);
  Del(Root);
  return 0;
}
