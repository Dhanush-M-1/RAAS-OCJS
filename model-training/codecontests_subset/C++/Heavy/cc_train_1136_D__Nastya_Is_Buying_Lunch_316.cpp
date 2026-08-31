#include <bits/stdc++.h>
using namespace std;
const int maxn = 3e5 + 10;
int pos[maxn], ans[maxn], a[maxn];
vector<int> e[maxn];
int main() {
  ios::sync_with_stdio(0);
  int n, m;
  cin >> n >> m;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    pos[a[i]] = i;
  }
  for (int i = 1; i <= m; i++) {
    int l, r;
    cin >> l >> r;
    e[r].push_back(l);
  }
  for (int j = 0; j < e[a[n]].size(); j++) {
    int v = e[a[n]][j];
    ans[v]++;
  }
  int now = n;
  for (int i = n - 1; i >= 1; i--) {
    if (i + ans[a[i]] == now) {
      now--;
      continue;
    }
    for (int j = 0; j < e[a[i]].size(); j++) {
      int v = e[a[i]][j];
      if (pos[v] < pos[a[i]]) {
        ans[v]++;
      }
    }
  }
  cout << n - now << endl;
}
