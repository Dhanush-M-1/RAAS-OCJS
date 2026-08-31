#include <bits/stdc++.h>
using namespace std;
const long long MOD = 1e9 + 7;
int n, x, y;
vector<int> g[100010];
int main() {
  cin >> n;
  for (int i = 0; i < n - 1; i++) {
    scanf("%d%d", &x, &y);
    g[x].push_back(y);
    g[y].push_back(x);
  }
  for (int i = 1; i <= n; i++) {
    if (g[i].size() == 2) {
      puts("NO");
      return 0;
    }
  }
  puts("YES");
  return 0;
}
