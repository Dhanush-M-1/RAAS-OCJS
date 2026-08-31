#include <bits/stdc++.h>
struct city {
  int estart;
  long long int tax;
  bool visited;
  int mex;
} v[200003];
struct edge {
  int enext, to;
} e[200003];
int n, m;
void dfs(int i) {
  v[i].visited = true;
  std::vector<int> temp;
  for (int j = v[i].estart; j != -1; j = e[j].enext) {
    int to = e[j].to;
    if (!v[to].visited) {
      dfs(to);
    }
    temp.push_back(v[to].mex);
  }
  std::sort(temp.begin(), temp.end());
  int mex = 0;
  for (int i = 0; i < temp.size(); ++i) {
    if (temp[i] > mex) break;
    if (temp[i] == mex) ++mex;
  }
  v[i].mex = mex;
}
long long int w[200003];
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 0; i < n; ++i) {
    scanf("%I64d", &v[i].tax);
    v[i].estart = -1;
  }
  for (int i = 0; i < m; ++i) {
    int a, b;
    scanf("%d%d", &a, &b);
    --a, --b;
    e[i].enext = v[a].estart;
    e[i].to = b;
    v[a].estart = i;
  }
  int maxm = 0;
  for (int i = 0; i < n; ++i) {
    if (!v[i].visited) {
      dfs(i);
    }
    if (v[i].mex > maxm) maxm = v[i].mex;
    w[v[i].mex] ^= v[i].tax;
  }
  int i = maxm;
  while (i >= 0 && w[i] == 0) --i;
  if (i == -1) {
    printf("LOSE\n");
    return 0;
  }
  int x = -1;
  for (int j = 0; j < n; ++j)
    if (v[j].mex == i && (v[j].tax ^ w[i]) < v[j].tax) {
      x = j;
      break;
    }
  v[x].tax ^= w[i];
  w[i] = 0;
  for (int j = v[x].estart; j != -1; j = e[j].enext) {
    int to = e[j].to;
    if (v[to].mex < i) {
      v[to].tax ^= w[v[to].mex];
      w[v[to].mex] = 0;
    }
  }
  printf("WIN\n");
  for (int i = 0; i < n; ++i) {
    printf("%I64d ", v[i].tax);
  }
  printf("\n");
}
