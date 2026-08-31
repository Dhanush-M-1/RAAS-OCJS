#include <bits/stdc++.h>
using namespace std;
int main(int argc, char const *argv[]) {
  int n, m, k;
  cin >> n >> m >> k;
  vector<vector<int> > edges(m, vector<int>(2));
  vector<vector<int> > graph(n + 1);
  vector<int> degrees(n + 1, 0);
  for (int i = 0; i < m; ++i) {
    scanf("%d %d", &edges[i][0], &edges[i][1]);
    degrees[edges[i][0]]++;
    degrees[edges[i][1]]++;
    graph[edges[i][0]].push_back(edges[i][1]);
    graph[edges[i][1]].push_back(edges[i][0]);
  }
  map<pair<int, int>, bool> sorted;
  for (int i = 0; i < n; ++i)
    sorted.insert(make_pair(make_pair(degrees[i + 1], i + 1), 1));
  vector<int> ans(m);
  for (int i = m - 1; i >= 0; --i) {
    while ((!sorted.empty()) and sorted.begin()->first.first < k) {
      int temp = sorted.begin()->first.second;
      sorted.erase(sorted.begin());
      degrees[temp] = 0;
      for (int i = 0; i < graph[temp].size(); ++i) {
        auto it =
            sorted.find(make_pair(degrees[graph[temp][i]], graph[temp][i]));
        degrees[graph[temp][i]]--;
        if (it != sorted.end()) {
          sorted.erase(it);
          if (degrees[graph[temp][i]] >= 0)
            sorted.insert(make_pair(
                make_pair(degrees[graph[temp][i]], graph[temp][i]), 1));
        }
      }
    }
    ans[i] = sorted.size();
    graph[edges[i][0]].pop_back();
    graph[edges[i][1]].pop_back();
    if (degrees[edges[i][0]] >= k and degrees[edges[i][1]] >= k) {
      auto it1 = sorted.find(make_pair(degrees[edges[i][0]], edges[i][0]));
      auto it2 = sorted.find(make_pair(degrees[edges[i][1]], edges[i][1]));
      degrees[edges[i][0]]--;
      degrees[edges[i][1]]--;
      if (it1 != sorted.end()) {
        sorted.erase(it1);
        sorted.insert(
            make_pair(make_pair(degrees[edges[i][0]], edges[i][0]), 1));
      }
      if (it2 != sorted.end()) {
        sorted.erase(it2);
        sorted.insert(
            make_pair(make_pair(degrees[edges[i][1]], edges[i][1]), 1));
      }
    }
  }
  for (int i = 0; i < m; ++i) printf("%d\n", ans[i]);
  return 0;
}
