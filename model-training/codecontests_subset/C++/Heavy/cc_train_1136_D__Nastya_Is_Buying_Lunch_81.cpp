#include <bits/stdc++.h>
using namespace std;
const int MAX = 3e5 + 5;
struct Edge {
  int u, v;
};
int arr[MAX];
int arrpos[MAX];
int number[MAX];
map<pair<int, int>, int> mp;
inline int read() {
  int s = 0, w = 1;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') w = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') s = s * 10 + ch - '0', ch = getchar();
  return s * w;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n, m;
  n = read();
  m = read();
  for (int i = 1; i <= n; ++i) {
    arr[i] = read();
    arrpos[arr[i]] = i;
  }
  int ans = 0;
  for (int i = 0, u, v; i < m; ++i) {
    u = read();
    v = read();
    if (!mp[make_pair(u, v)]) {
      mp[make_pair(u, v)] = 1;
      if (arrpos[u] < arrpos[v])
        ++number[u];
      else
        ++number[v];
    }
  }
  for (int i = n - 1; i >= 1; --i) {
    if (!mp[make_pair(arr[i], arr[n])]) continue;
    if (number[arr[i]] >= n - ans - i) ++ans;
  }
  cout << ans << endl;
  return 0;
}
