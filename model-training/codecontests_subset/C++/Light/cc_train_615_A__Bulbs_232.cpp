#include <bits/stdc++.h>
using namespace std;
const int N = 200;
int vis[N];
bool f(int len) {
  for (int i = 1; i <= len; ++i) {
    if (!vis[i]) return false;
  }
  return true;
}
int main() {
  int i, j;
  int n, m;
  scanf("%d%d", &n, &m);
  for (i = 0; i < n; ++i) {
    int t;
    scanf("%d", &t);
    for (j = 0; j < t; ++j) {
      int tt;
      scanf("%d", &tt);
      vis[tt] = 1;
    }
  }
  cout << (f(m) ? "YES" : "NO") << endl;
}
