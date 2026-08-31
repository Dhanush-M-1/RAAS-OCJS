#include <bits/stdc++.h>
int n, k;
std::vector<std::vector<int> > g(1000010);
int cnt[1000010] = {0};
int max[1000010] = {0};
int ans = 0;
void dfs(int index, int parent) {
  for (int i = 0; i < g[index].size(); ++i) {
    int next = g[index][i];
    if (next != index) {
      dfs(next, index);
    }
  }
  if (g[index].size() == 0 && index != 0) {
    ++cnt[parent];
    max[parent] = std::max(max[parent], k - 1);
  }
  if (max[index] > 0 && parent != -1) {
    cnt[parent] += cnt[index];
    cnt[index] = 0;
    max[parent] = std::max(max[parent], max[index] - 1);
  }
}
void getans(int index, int parent, int curCnt) {
  curCnt += cnt[index];
  for (int i = 0; i < g[index].size(); ++i) {
    int next = g[index][i];
    if (next != parent) {
      getans(next, index, curCnt);
    }
  }
  if (curCnt > ans) ans = curCnt;
}
int main() {
  std::cin >> n >> k;
  for (int i = 1; i < n; ++i) {
    int x;
    std::cin >> x;
    --x;
    g[x].push_back(i);
  }
  dfs(0, -1);
  getans(0, -1, 0);
  std::cout << ans;
}
