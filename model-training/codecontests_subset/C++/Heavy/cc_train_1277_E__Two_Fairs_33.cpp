#include <bits/stdc++.h>
using namespace std;
int n, m, a, b;
unordered_set<int> arr1, arr2;
vector<int> arr[200005];
bool visited[200005];
void bfs1(int x) {
  if (visited[x]) return;
  visited[x] = 1;
  for (int i : arr[x]) {
    if (i == b || visited[i]) continue;
    arr1.insert(i);
    bfs1(i);
  }
}
void bfs2(int x) {
  if (visited[x]) return;
  visited[x] = 1;
  for (int i : arr[x]) {
    if (visited[i] || i == a) continue;
    if (arr1.find(i) != arr1.end())
      arr1.erase(i);
    else {
      arr2.insert(i);
    }
    bfs2(i);
  }
}
int main() {
  int t;
  cin >> t;
  while (t--) {
    cin >> n >> m >> a >> b;
    memset(visited, 0, sizeof(visited));
    arr1.clear();
    arr2.clear();
    for (int i = 0; i <= n; i++) arr[i].clear();
    for (int i = 0; i < m; i++) {
      int x, y;
      cin >> x >> y;
      arr[x].push_back(y);
      arr[y].push_back(x);
    }
    memset(visited, 0, sizeof(visited));
    bfs1(a);
    memset(visited, 0, sizeof(visited));
    bfs2(b);
    long long aa = arr1.size();
    long long bb = arr2.size();
    cout << aa * bb << endl;
  }
  return 0;
}
