#include <bits/stdc++.h>
using namespace std;
long long inf = 1000000;
const int N = 300000;
vector<int> tree(2 * N + 4);
vector<int> ranks(2 * N + 4, 0);
char str[N + 4];
int find(int x) { return x == tree[x] ? x : tree[x] = find(tree[x]); }
void link(int x, int y) {
  if (ranks[x] > ranks[y]) {
    tree[y] = x;
  } else {
    tree[x] = y;
    if (ranks[x] == ranks[y]) {
      ranks[y]++;
    }
  }
}
long long sum = 0;
vector<vector<int>> graph(N);
vector<int> dists(2 * N);
bool visited[2 * N] = {false};
int main() {
  ios_base::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  cin.exceptions(cin.failbit);
  int n, k;
  cin >> n >> k;
  cin >> str;
  for (int i = 0; i < k; i++) {
    tree[i] = i;
    tree[i + N] = i + N;
    dists[i] = 1;
    dists[i + N] = 0;
  }
  for (int i = 0; i < k; i++) {
    int len;
    cin >> len;
    for (int a = 0; a < len; a++) {
      int e;
      cin >> e;
      e--;
      graph[e].push_back(i);
    }
  }
  for (int i = 0; i < n; i++) {
    if (graph[i].empty()) {
      cout << sum << "\n";
      continue;
    }
    if (graph[i].size() == 1) {
      if (str[i] == '0') {
        if (!visited[graph[i][0]]) {
          visited[graph[i][0]] = true;
          sum++;
          visited[graph[i][0] + N] = true;
          dists[graph[i][0] + N] = inf;
        } else {
          int x = find(graph[i][0]);
          int y = find(graph[i][0] + N);
          sum -= min(dists[x], dists[y]);
          dists[y] = inf;
          sum += dists[x];
        }
      } else {
        if (!visited[graph[i][0]]) {
          visited[graph[i][0]] = true;
          visited[graph[i][0] + N] = true;
          dists[graph[i][0]] = inf;
        } else {
          int x = find(graph[i][0]);
          int y = find(graph[i][0] + N);
          sum -= min(dists[x], dists[y]);
          dists[x] = inf;
          sum += dists[y];
        }
      }
    } else {
      if (graph[i].size() > 2) {
        cout << "?????\n";
      }
      int x1 = find(graph[i][0]);
      int x2 = find(graph[i][0] + N);
      int y1 = find(graph[i][1]);
      int y2 = find(graph[i][1] + N);
      if (!visited[graph[i][0]]) {
        visited[graph[i][0]] = true;
        visited[graph[i][0] + N] = true;
      }
      if (!visited[graph[i][1]]) {
        visited[graph[i][1]] = true;
        visited[graph[i][1] + N] = true;
      }
      sum -= min(dists[x1], dists[x2]);
      sum -= min(dists[y1], dists[y2]);
      if (str[i] == '0') {
        if (x1 == y2) {
          sum += min(dists[x1], dists[x2]);
        } else if (dists[x1] == inf) {
          tree[y2] = x1;
          y2 = x1;
        } else if (dists[y2] == inf) {
          tree[x1] = y2;
          x1 = y2;
        } else {
          tree[y2] = x1;
          dists[x1] += dists[y2];
          y2 = x1;
        }
        if (dists[x2] == inf) {
          tree[y1] = x2;
          y1 = x2;
        } else if (dists[y1] == inf) {
          tree[x2] = y1;
          x2 = y1;
        } else if (x2 != y1) {
          tree[x2] = y1;
          dists[y1] += dists[x2];
          x2 = y1;
        }
        sum += min(dists[x1], dists[x2]);
      } else {
        if (x1 == y1) {
          sum += min(dists[x1], dists[x2]);
        } else if (dists[x1] == inf) {
          tree[y1] = x1;
          y1 = x1;
        } else if (dists[y1] == inf) {
          tree[x1] = y1;
          x1 = y1;
        } else {
          tree[y1] = x1;
          dists[x1] += dists[y1];
          y1 = x1;
        }
        if (dists[x2] == inf) {
          tree[y2] = x2;
          y2 = x2;
        } else if (dists[y2] == inf) {
          tree[x2] = y2;
          x2 = y2;
        } else if (x2 != y2) {
          tree[x2] = y2;
          dists[y2] += dists[x2];
          x2 = y2;
        }
        sum += min(dists[x1], dists[x2]);
      }
    }
    cout << sum << "\n";
  }
}
