#include <bits/stdc++.h>
using namespace std;
int h[35], g[35];
int n;
int ret;
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) cin >> h[i] >> g[i];
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= n; j++)
      if (i != j && h[i] == g[j]) ret++;
  cout << ret;
  return 0;
}
