#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e5 + 5;
int de[maxn];
int main() {
  ios::sync_with_stdio(false);
  int n;
  cin >> n;
  memset(de, 0, sizeof de);
  for (int i = 0; i < n - 1; i++) {
    int u, v;
    cin >> u >> v;
    de[u]++;
    de[v]++;
  }
  bool flag = true;
  for (int i = 1; i <= n; i++) {
    if (de[i] == 2) {
      flag = false;
      break;
    }
  }
  if (flag)
    puts("YES");
  else
    puts("NO");
}
