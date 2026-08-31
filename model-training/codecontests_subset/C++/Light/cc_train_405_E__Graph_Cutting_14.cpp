#include <bits/stdc++.h>
using namespace std;
int n, m, first[110000], len;
struct node {
  int x, y, next;
} e[210000];
bool v[210000];
void ins(int x, int y) {
  len++;
  e[len].x = x;
  e[len].y = y;
  e[len].next = first[x];
  first[x] = len;
}
int Dfs(int x) {
  vector<int> Set;
  Set.clear();
  vector<int> UNP;
  UNP.clear();
  for (int k = first[x]; k != -1; k = e[k].next)
    if (v[k]) {
      v[k] = v[k ^ 1] = false;
      Set.push_back(e[k].y);
    }
  for (int i = 0; i < Set.size(); i++) {
    int w = Dfs(Set[i]);
    if (w)
      printf("%d %d %d\n", x, Set[i], w);
    else
      UNP.push_back(Set[i]);
  }
  while (UNP.size() >= 2) {
    int u = UNP[UNP.size() - 1], w = UNP[UNP.size() - 2];
    printf("%d %d %d\n", u, x, w);
    UNP.pop_back();
    UNP.pop_back();
  }
  if (UNP.size())
    return UNP[0];
  else
    return 0;
}
int main() {
  scanf("%d%d", &n, &m);
  len = 1;
  memset(first, -1, sizeof(first));
  for (int i = 1; i <= m; i++) {
    int x, y;
    scanf("%d%d", &x, &y);
    ins(x, y);
    ins(y, x);
  }
  memset(v, 1, sizeof(v));
  if (m % 2 == 1)
    printf("No solution\n");
  else
    Dfs(1);
  return 0;
}
