#include <bits/stdc++.h>
using namespace std;
const int N = 3e5 + 10;
int a[N], cnt, res;
vector<int> change[N];
bool t[N];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  ;
  int n, m;
  cin >> n >> m;
  for (int i = 1; i <= n; i++) cin >> a[i];
  for (int i = 1; i <= m; i++) {
    int u, v;
    cin >> u >> v;
    change[u].push_back(v);
  }
  t[a[n]] = 1;
  cnt = 1;
  for (int i = n - 1; i >= 1; i--) {
    int k = 0;
    for (__typeof(change[a[i]].begin()) it = change[a[i]].begin();
         it != change[a[i]].end(); it++)
      k += t[*it];
    if (k < cnt) {
      cnt++;
      t[a[i]] = 1;
    } else
      res++;
  }
  cout << res;
  return 0;
}
