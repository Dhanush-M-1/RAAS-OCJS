#include <bits/stdc++.h>
using namespace std;
int n, ans;
vector<int> v1[100005];
vector<int> v2[100005];
bool isexist(int sign, int x, int y) {
  vector<int> *v;
  if (sign == 0)
    v = &v1[x];
  else
    v = &v2[x];
  if (x < 0 || x > 100000) return false;
  return binary_search((*v).begin(), (*v).end(), y);
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    int a, b;
    scanf("%d%d", &a, &b);
    v1[a].push_back(b);
  }
  for (int i = 0; i <= 100000; i++) sort(v1[i].begin(), v1[i].end());
  for (int i = 0; i <= 100000; i++) {
    if (v1[i].size() <= 400) {
      for (int p1 = 0; p1 < v1[i].size(); p1++) {
        for (int p2 = p1 + 1; p2 < v1[i].size(); p2++) {
          if (isexist(0, i - (v1[i][p2] - v1[i][p1]), v1[i][p1]) &&
              isexist(0, i - (v1[i][p2] - v1[i][p1]), v1[i][p2]))
            ans++;
          if (isexist(0, i + (v1[i][p2] - v1[i][p1]), v1[i][p1]) &&
              isexist(0, i + (v1[i][p2] - v1[i][p1]), v1[i][p2]))
            ans++;
        }
      }
      v1[i].clear();
    }
  }
  for (int i = 0; i <= 100000; i++) {
    for (auto j : v1[i]) {
      v2[j].push_back(i);
    }
  }
  for (int i = 0; i <= 100000; i++) sort(v2[i].begin(), v2[i].end());
  for (int i = 0; i <= 100000; i++) {
    if (v2[i].size() <= 400) {
      for (int p1 = 0; p1 < v2[i].size(); p1++) {
        for (int p2 = p1 + 1; p2 < v2[i].size(); p2++) {
          if (isexist(1, i - (v2[i][p2] - v2[i][p1]), v2[i][p1]) &&
              isexist(1, i - (v2[i][p2] - v2[i][p1]), v2[i][p2]))
            ans++;
          if (isexist(1, i + (v2[i][p2] - v2[i][p1]), v2[i][p1]) &&
              isexist(1, i + (v2[i][p2] - v2[i][p1]), v2[i][p2]))
            ans++;
        }
      }
      v2[i].clear();
    }
  }
  printf("%d\n", ans);
  return 0;
}
