#include <bits/stdc++.h>
using namespace std;
map<pair<int, int>, int> adj;
int a[300005], rnk[300005];
int main() {
  int n, m, k, x, y;
  cin >> n >> m;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    rnk[a[i]] = i;
  }
  k = a[n];
  for (int i = 1; i <= m; i++) {
    cin >> x >> y;
    if (rnk[x] < rnk[y]) adj[make_pair(x, y)] = 1;
  }
  int rp = n;
  for (int i = n - 1; i >= 1; i--) {
    int j = i;
    while (j < rp && adj[make_pair(a[j], a[j + 1])]) {
      swap(a[j], a[j + 1]);
      j++;
    }
    if (j == rp) rp--;
  }
  cout << n - rp << endl;
  return 0;
}
