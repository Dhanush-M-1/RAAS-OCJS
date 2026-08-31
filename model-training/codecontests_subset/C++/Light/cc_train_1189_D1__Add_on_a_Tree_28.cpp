#include <bits/stdc++.h>
using namespace std;
const int MAX_N = 1e5 + 5;
int n;
vector<int> G[MAX_N];
bool ans = true;
int main() {
  scanf("%d", &n);
  for (int i = 0, t1, t2; i < n - 1; i++) {
    scanf("%d%d", &t1, &t2);
    G[t1].emplace_back(t2);
    G[t2].emplace_back(t1);
  }
  for (int i = 1; i <= n; i++)
    if (G[i].size() == 2) {
      ans = false;
      break;
    }
  puts(ans ? "YES" : "NO");
  return 0;
}
