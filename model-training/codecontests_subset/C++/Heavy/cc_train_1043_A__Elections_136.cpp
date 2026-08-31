#include <bits/stdc++.h>
using namespace std;
const long long int N = 200005;
vector<long long int> graph[N];
long long int level[N];
long long int subtree[N];
bool vis[N];
void dfs(long long int curr) {
  vis[curr] = 1;
  long long int size = 0;
  for (auto x : graph[curr]) {
    if (!vis[x]) {
      level[x] = level[curr] + 1;
      dfs(x);
      size += subtree[x];
    }
  }
  subtree[curr] = 1 + size;
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long int t = 1;
  while (t--) {
    long long int n;
    cin >> n;
    long long int a[n];
    long long int sum = 0;
    long long int mx = INT_MIN;
    for (long long int i = 0; i < n; i++) {
      cin >> a[i];
      sum += a[i];
      mx = max(mx, a[i]);
    }
    long long int sum2 = 0;
    long long int x = mx;
    while (sum2 <= sum) {
      sum2 = 0;
      for (long long int i = 0; i < n; i++) {
        sum2 += (x - a[i]);
      }
      x++;
    }
    cout << x - 1 << '\n';
  }
  return 0;
}
