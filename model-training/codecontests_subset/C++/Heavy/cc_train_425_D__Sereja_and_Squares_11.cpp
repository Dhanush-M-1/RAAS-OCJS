#include <bits/stdc++.h>
using namespace std;
vector<int> vec[100001];
bool find(int x, int y) {
  if (x >= 100001) return false;
  return binary_search(vec[x].begin(), vec[x].end(), y);
}
int main() {
  int N, x, y, ans, d;
  scanf("%d", &N);
  for (int i = 0; i < N; i++) {
    scanf("%d%d", &x, &y);
    vec[x].push_back(y);
  }
  for (int i = 0; i < 100001; i++) sort(vec[i].begin(), vec[i].end());
  ans = 0;
  for (int i = 0; i < 100001; i++)
    if (vec[i].size() < 500) {
      for (int j = 0, deg = vec[i].size(); j < deg; j++)
        for (int k = j + 1; k < deg; k++) {
          d = vec[i][k] - vec[i][j];
          if (find(i + d, vec[i][j]) && find(i + d, vec[i][k])) ans++;
        }
    } else {
      for (int j = i + 1; j < 100001; j++)
        for (int k = 0, deg = vec[j].size(); k < deg; k++) {
          d = j - i;
          if (find(i, vec[j][k]) && find(i, vec[j][k] + d) &&
              find(j, vec[j][k] + d))
            ans++;
        }
    }
  printf("%d\n", ans);
  return 0;
}
