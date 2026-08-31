#include <bits/stdc++.h>
using namespace std;
int W[510];
int L[1010];
int P[510];
int main() {
  int n, m, i, j, k;
  memset(W, 0, sizeof(W));
  memset(L, 0, sizeof(L));
  memset(P, 0, sizeof(P));
  cin >> n >> m;
  for (i = 1; i <= n; i++) cin >> W[i];
  for (i = 0; i < m; i++) cin >> L[i];
  vector<int> list;
  for (i = 0; i < m; i++) {
    if (P[L[i]] == 0) {
      list.push_back(L[i]);
      P[L[i]] = 1;
    }
  }
  int res = 0;
  for (i = 0; i < m; i++) {
    k = L[i];
    for (j = 0; j < list.size(); j++) {
      if (list[j] == k) {
        list.erase(list.begin() + j);
        list.insert(list.begin(), k);
        break;
      } else {
        res += W[list[j]];
      }
    }
  }
  cout << res << endl;
  return 0;
}
