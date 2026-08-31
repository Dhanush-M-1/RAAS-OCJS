#include <bits/stdc++.h>
using namespace std;
bool blocked[1000002];
int lastFree[1000002];
long long costs[1000002];
int main() {
  int k, n, m;
  cin >> n >> m >> k;
  int x;
  for (int i = 1; i <= m; i++) {
    scanf("%d", &x);
    blocked[x + 1] = true;
  }
  memset(lastFree, -1, sizeof(lastFree));
  for (int i = 1; i <= n; i++) {
    if (blocked[i])
      lastFree[i] = lastFree[i - 1];
    else
      lastFree[i] = i;
  }
  long long res = -1;
  for (int i = 1; i <= k; i++) {
    scanf("%d", &costs[i]);
    int toPlace = 1;
    int ctr = 0;
    while (toPlace <= n && lastFree[toPlace] != -1 &&
           lastFree[toPlace] + i > toPlace) {
      toPlace = lastFree[toPlace] + i;
      ctr++;
    }
    if (toPlace > n) {
      if (res == -1)
        res = costs[i] * ctr;
      else
        res = min(res, costs[i] * ctr);
    }
  }
  cout << res << '\n';
}
