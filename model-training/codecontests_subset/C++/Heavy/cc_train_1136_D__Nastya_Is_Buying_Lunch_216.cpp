#include <bits/stdc++.h>
using namespace std;
const int mod = 1000000007, M = 3e5 + 7;
int powe(int x, int y) {
  x = x % mod;
  int ans = 1;
  while (y > 0) {
    if (y & 1) {
      ans = (1ll * x * ans) % mod;
    }
    y >>= 1;
    x = (1ll * x * x) % mod;
  }
  return ans;
}
vector<vector<int> > edg(M);
int arr[M];
int pas[M];
set<int> pass, lis;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  int n, m, ctr = 0, a, b;
  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
  }
  for (int i = 0; i < m; i++) {
    cin >> a >> b;
    edg[a].push_back(b);
    if (b == arr[n - 1]) pas[a] = 1;
  }
  for (int i = n - 2; i >= 0; i--) {
    if (pas[arr[i]]) {
      bool pass = false;
      if (edg[arr[i]].size() < lis.size()) {
        lis.insert(arr[i]);
        continue;
      }
      sort(edg[arr[i]].begin(), edg[arr[i]].end());
      auto i2 = lis.begin();
      int i1 = 0, lim = edg[arr[i]].size();
      for (; i2 != lis.end() && i1 < lim;) {
        while (i1 < n && edg[arr[i]][i1] < *i2) {
          i1++;
        }
        if (edg[arr[i]][i1] == *i2) {
          i1++, i2++;
        } else
          break;
      }
      if (i2 == lis.end()) {
        pass = true;
      }
      if (pass)
        ctr++;
      else {
        lis.insert(arr[i]);
      }
    } else
      lis.insert(arr[i]);
  }
  cout << ctr;
  return 0;
}
