#include <bits/stdc++.h>
using namespace std;
vector<int> edges[300000];
int n, m, x, y, z, p, q, r;
int sbtree[300000], isTaken[300000], degree[300000], bdchld[300000];
vector<int> anss;
void dfs1(int pos) {
  sbtree[pos]++;
  for (int to : edges[pos]) {
    dfs1(to);
    sbtree[pos] += sbtree[to];
  }
}
void dfs(int pos) {
  bool flg = true;
  for (int to : edges[pos]) {
    if (sbtree[to] % 2 == 0) {
      dfs(to);
    }
  }
  anss.push_back(pos);
  for (int to : edges[pos]) {
    if (sbtree[to] % 2) {
      dfs(to);
    }
  }
}
int main() {
  int root = 1;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    scanf("%d", &x);
    edges[x].push_back(i);
    degree[x]++;
    degree[i]++;
    if (x == 0) root = i;
  }
  if (n % 2 == 0) {
    cout << "NO" << endl;
    return 0;
  }
  cout << "YES" << endl;
  dfs1(root);
  dfs(root);
  for (int xx : anss) printf("%d\n", xx);
  return 0;
}
