#include <bits/stdc++.h>
using namespace std;
struct Dsu {
  vector<int> parent, rnk;
  Dsu(int n) {
    parent.resize(n);
    rnk.resize(n);
    for (int i = 0; i < n; i++) {
      parent[i] = i;
      rnk[i] = 0;
    }
  }
  int findparent(int i) {
    if (parent[i] != i) parent[i] = findparent(parent[i]);
    return parent[i];
  }
  bool con(int x, int y) {
    if (findparent(x) == findparent(y)) return 1;
    return 0;
  }
  void uni(int x, int y) {
    int xroot = findparent(x);
    int yroot = findparent(y);
    if (rnk[yroot] < rnk[xroot])
      parent[yroot] = parent[xroot];
    else if (rnk[yroot] > rnk[xroot])
      parent[xroot] = parent[yroot];
    else {
      rnk[xroot]++;
      parent[yroot] = parent[xroot];
    }
  }
};
int main() {
  int n, k;
  scanf("%d%d", &n, &k);
  int res = 1e9;
  for (int i = 0; i < n; i++) {
    int x;
    scanf("%d", &x);
    if (k % x == 0) {
      res = min(res, k / x);
    }
  }
  cout << res;
  return 0;
}
