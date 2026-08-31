#include <bits/stdc++.h>
using namespace std;
const int N = 2e3 + 5;
int arr[N], cnt, n, k;
bool vis[N], found;
int dp[N];
vector<int> tree[N], v;
void dfs(int u) {
  if (u == k) found = 1;
  cnt++;
  vis[u] = 1;
  for (int i = 0; i < tree[u].size(); i++) {
    int to = tree[u][i];
    dfs(to);
  }
}
int main() {
  scanf("%d%d", &n, &k);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &arr[i]);
    if (arr[i] != 0) tree[arr[i]].push_back(i);
  }
  int infront = 0;
  for (int i = 1; i <= n; i++) {
    if (arr[i] == 0) {
      found = 0;
      cnt = 0;
      dfs(i);
      if (!found)
        v.push_back(cnt);
      else {
        int cur = k;
        while (arr[cur] != 0) {
          infront++;
          cur = arr[cur];
        }
        infront++;
      }
    }
  }
  sort(v.begin(), v.end());
  dp[infront] = 1;
  for (int i = 0; i < v.size(); i++) {
    for (int j = 1000; j >= 1; j--)
      if (dp[j]) dp[j + v[i]] = 1;
  }
  for (int i = 1; i <= n; i++)
    if (dp[i]) cout << i << endl;
  return 0;
}
