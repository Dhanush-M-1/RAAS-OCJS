#include <bits/stdc++.h>
using namespace std;
vector<int> ve[110000];
int n;
bool check(int x, int y) {
  if (x > 100000 || ve[x].size() == 0) return false;
  return binary_search(ve[x].begin(), ve[x].end(), y);
}
int main() {
  int i, x, y, j, g, ans = 0, len, l;
  scanf("%d", &n);
  for (i = 1; i <= n; i++) {
    scanf("%d%d", &x, &y);
    ve[x].push_back(y);
  }
  for (i = 0; i <= 100000; i++) sort(ve[i].begin(), ve[i].end());
  for (i = 0; i <= 100000; i++) {
    l = ve[i].size();
    if (l >= 500) {
      for (j = i + 1; j <= 100000; j++) {
        for (g = 0; g < ve[j].size(); g++) {
          if (check(i, ve[j][g]) && check(i, ve[j][g] + j - i) &&
              check(j, ve[j][g] + j - i))
            ans++;
        }
      }
    } else {
      for (j = 0; j < ve[i].size(); j++) {
        for (g = j + 1; g < ve[i].size(); g++) {
          len = ve[i][g] - ve[i][j];
          if (check(i + len, ve[i][j]) && check(i + len, ve[i][g])) ans++;
        }
      }
    }
  }
  printf("%d\n", ans);
}
