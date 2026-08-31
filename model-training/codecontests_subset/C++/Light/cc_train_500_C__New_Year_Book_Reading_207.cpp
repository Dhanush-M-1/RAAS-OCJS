#include <bits/stdc++.h>
using namespace std;
int w[509];
int vis[509];
vector<int> order;
int book[1009];
long long int doit(int b) {
  long long int res = 0;
  for (int i = 0; i < (int)order.size(); i++) {
    if (order[i] == b) break;
    res += w[order[i]];
  }
  vector<int> n_o;
  n_o.push_back(b);
  for (int i = 0; i < (int)order.size(); i++) {
    if (order[i] == b) {
      continue;
    }
    n_o.push_back(order[i]);
  }
  order = n_o;
  return res;
}
int main() {
  int n, m, ww;
  cin >> n >> m;
  for (int i = 1; i <= n; i++) {
    cin >> w[i];
  }
  for (int i = 1; i <= m; i++) {
    cin >> book[i];
    if (!vis[book[i]]) {
      order.push_back(book[i]);
      vis[book[i]] = 1;
    }
  }
  long long int res = 0;
  for (int i = 1; i <= m; i++) {
    res += doit(book[i]);
  }
  cout << res << "\n";
  return 0;
}
