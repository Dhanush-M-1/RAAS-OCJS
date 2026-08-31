#include <bits/stdc++.h>
using namespace std;
int a, b;
int vis1[200005], vis2[200005];
vector<int> arr[200005];
void ini(int n, int vis1[], int vis2[]) {
  for (int i = 0; i <= n; i++) {
    vis1[i] = 0, vis2[i] = 0;
    arr[i].clear();
  }
}
void dfs1(int s, int vis1[]) {
  vis1[s] = 1;
  for (int i = 0; i < arr[s].size(); i++) {
    if (arr[s][i] != b && vis1[arr[s][i]] == 0) dfs1(arr[s][i], vis1);
  }
}
void dfs2(int s, int vis2[]) {
  vis2[s] = 1;
  for (int i = 0; i < arr[s].size(); i++) {
    if (arr[s][i] != a && vis2[arr[s][i]] == 0) dfs2(arr[s][i], vis2);
  }
}
int main() {
  int tt = 1;
  scanf("%d", &tt);
  ;
  while (tt--) {
    int i, n, m, x, y;
    unsigned long long int ans1 = 0, ans2 = 0;
    scanf("%d %d", &n, &m);
    ;
    scanf("%d %d", &a, &b);
    ;
    for (int i = 0; i < m; i++) {
      scanf("%d %d", &x, &y);
      ;
      arr[x].push_back(y);
      arr[y].push_back(x);
    }
    dfs1(a, vis1);
    dfs2(b, vis2);
    for (int i = 1; i <= n; i++) {
      if (vis2[i] == 0 && vis1[i] == 1 && i != a && i != b)
        ans1++;
      else if (vis2[i] == 1 && vis1[i] == 0 && i != a && i != b)
        ans2++;
    }
    unsigned long long int ans = ans1 * ans2;
    printf("%lli\n", ans);
    ini(n + 1, vis1, vis2);
  }
  return 0;
}
