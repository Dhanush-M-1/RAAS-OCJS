#include <bits/stdc++.h>
using namespace std;
vector<int> G[(int)(1e5 + 500)];
map<pair<int, int>, int> block, done;
int process[(int)(1e5 + 500)];
void print(int x, int y, int z) {
  printf("%d", x);
  printf(" ");
  printf("%d", y);
  printf(" ");
  printf("%d", z);
  printf(" ");
  done[make_pair(x, y)] = done[make_pair(y, x)] = 1;
  done[make_pair(y, z)] = done[make_pair(z, y)] = 1;
}
int cut(int x) {
  vector<int> adj;
  for (int i = 0; i < G[x].size(); i++) {
    int to = G[x][i];
    if (block.find(make_pair(x, to)) == block.end()) {
      block[make_pair(x, to)] = block[make_pair(to, x)] = 1;
      adj.push_back(to);
    }
  }
  for (int i = 0; i < adj.size(); i++) {
    int to = adj[i];
    if (!process[to]) {
      int z = cut(to);
      if (z) {
        print(x, to, z);
      }
    }
  }
  int other = 0;
  for (int i = 0; i < adj.size(); i++) {
    int to = adj[i];
    if (!done[make_pair(x, to)]) {
      if (other == 0) {
        other = to;
      } else {
        print(other, x, to);
        other = 0;
      }
    }
  }
  process[x] = 1;
  return other;
}
void solve() {
  int n, m;
  scanf("%d", &n);
  scanf("%d", &m);
  if (m % 2) {
    printf("No solution");
    return;
  }
  for (int i = 1; i <= m; i++) {
    int x, y;
    scanf("%d", &x);
    scanf("%d", &y);
    G[x].push_back(y);
    G[y].push_back(x);
  }
  cut(1);
}
int main() {
  int t = 1;
  for (int i = 1; i <= t; i++) {
    solve();
  }
  return 0;
}
