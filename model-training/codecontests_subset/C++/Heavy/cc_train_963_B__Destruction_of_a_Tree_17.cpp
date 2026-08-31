#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 5;
vector<int> e[N];
int n, cnt[N];
void dfs(int x, int fa) {
  cnt[x] = 1;
  int len = e[x].size();
  for (int i = 0; i < len; i++) {
    if (e[x][i] == fa) continue;
    dfs(e[x][i], x);
    cnt[x] += cnt[e[x][i]];
  }
}
void solve(int x, int fa) {
  int len = e[x].size();
  for (int i = 0; i < len; i++) {
    if (e[x][i] == fa) continue;
    if (cnt[e[x][i]] % 2 == 0) {
      solve(e[x][i], x);
    }
  }
  printf("%d\n", x);
  for (int i = 0; i < len; i++) {
    if (e[x][i] == fa) continue;
    if (cnt[e[x][i]] % 2 == 1) {
      solve(e[x][i], x);
    }
  }
}
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    int x;
    scanf("%d", &x);
    if (x == 0) continue;
    e[i].push_back(x);
    e[x].push_back(i);
  }
  dfs(1, 0);
  if (cnt[1] & 1) {
    printf("YES\n");
    solve(1, 0);
  } else {
    printf("NO");
  }
  return 0;
}
