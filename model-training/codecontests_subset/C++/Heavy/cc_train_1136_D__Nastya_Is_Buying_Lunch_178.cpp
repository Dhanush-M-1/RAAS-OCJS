#include <bits/stdc++.h>
using namespace std;
const int N = 300005;
int arr[N];
vector<int> adj[N];
set<int> ss;
int ok[N];
int n, m;
int main() {
  scanf("%d %d", &n, &m);
  for (int i = 0; i < n; i++) scanf("%d", &arr[i]);
  for (int i = 0; i < m; i++) {
    int x, y;
    scanf("%d %d", &x, &y);
    if (y == arr[n - 1]) ok[x] = 1;
    adj[x].push_back(y);
  }
  int ans = 0;
  for (int i = n - 2; i >= 0; i--) {
    if (ok[arr[i]]) {
      int co = 0;
      for (int j : adj[arr[i]]) {
        if (ss.find(j) != ss.end()) co++;
      }
      if (co == ss.size())
        ans++;
      else
        ss.insert(arr[i]);
    } else
      ss.insert(arr[i]);
  }
  cout << ans << endl;
}
