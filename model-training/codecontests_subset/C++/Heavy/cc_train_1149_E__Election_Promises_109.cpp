#include <bits/stdc++.h>
using namespace std;
int h[200000];
vector<int> adjList[200000];
int nim[200000];
int doDFS(int u) {
  if (nim[u] != -1) return 0;
  int i, j = 0;
  vector<int> s;
  for (i = 0; i < adjList[u].size(); i++) {
    int v = adjList[u][i];
    doDFS(v), s.push_back(nim[v]);
  }
  sort(s.begin(), s.end());
  for (i = 0; i <= adjList[u].size(); i++) {
    while ((j < s.size()) && (s[j] < i)) j++;
    if ((j == s.size()) || (s[j] > i)) break;
  }
  nim[u] = i;
  return 0;
}
int x[200000], y[200000];
int main() {
  int i;
  int n, m, u, v;
  scanf("%d %d", &n, &m);
  for (i = 0; i < n; i++) scanf("%d", &h[i]);
  for (i = 0; i < m; i++) {
    scanf("%d %d", &u, &v);
    adjList[u - 1].push_back(v - 1);
  }
  int c = 0;
  fill(nim, nim + n, -1);
  for (i = 0; i < n; i++) doDFS(i), x[nim[i]] ^= h[i];
  for (i = 0; i < n; i++) {
    if (x[i] > 0) c++;
  }
  if (c == 0) {
    printf("LOSE\n");
    return 0;
  }
  int j;
  for (i = 0; i < n; i++) {
    if ((x[nim[i]] ^ h[i]) < h[i]) {
      int c2 = 1;
      for (j = 0; j < adjList[i].size(); j++) {
        int v = adjList[i][j];
        if ((x[nim[v]] > 0) && !y[nim[v]]) c2++;
        y[nim[v]] = 1;
      }
      if (c == c2) {
        h[i] ^= x[nim[i]];
        for (j = 0; j < adjList[i].size(); j++) {
          int v = adjList[i][j];
          h[v] ^= x[nim[v]], x[nim[v]] = 0;
        }
        printf("WIN\n");
        for (j = 0; j < n; j++)
          printf("%d%c", h[j], (j == (n - 1)) ? '\n' : ' ');
        break;
      } else {
        for (j = 0; j < adjList[i].size(); j++) y[nim[adjList[i][j]]] = 0;
      }
    }
  }
  return 0;
}
