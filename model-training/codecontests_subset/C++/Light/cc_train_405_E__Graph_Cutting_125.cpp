#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e5 + 123;
vector<int> v[maxn];
int n, m, High[maxn];
bool mark[maxn];
int Dfs(int Vert, int Dad) {
  mark[Vert] = true;
  vector<int> now;
  now.clear();
  for (__typeof(v[Vert].begin()) i = v[Vert].begin(); i != v[Vert].end(); ++i)
    if (!mark[*i]) {
      High[*i] = High[Vert] + 1;
      if (Dfs(*i, Vert) == 1) now.push_back(*i);
    } else if (*i != Dad and High[*i] < High[Vert])
      now.push_back(*i);
  while (now.size() >= 2) {
    int x = now.back();
    now.pop_back();
    int y = now.back();
    now.pop_back();
    printf("%d %d %d\n", x, Vert, y);
  }
  if (now.empty())
    return 1;
  else {
    printf("%d %d %d\n", now[0], Vert, Dad);
    return 0;
  }
}
int main() {
  int fi, se;
  cin >> n >> m;
  if (m % 2) {
    puts("No solution");
    return 0;
  }
  while (m--) {
    cin >> fi >> se;
    v[fi].push_back(se);
    v[se].push_back(fi);
  }
  Dfs(1, 0);
  return 0;
}
