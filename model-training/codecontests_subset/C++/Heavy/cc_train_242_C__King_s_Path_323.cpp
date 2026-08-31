#include <bits/stdc++.h>
using namespace std;
set<pair<int, int>> nodeSet;
set<pair<int, int>> alreadyTaken;
queue<pair<int, int>> que;
queue<int> dist;
int x[] = {1, 1, 1, 0, 0, -1, -1, -1};
int y[] = {-1, 0, 1, -1, 1, -1, 0, 1};
pair<int, int> currentNode;
pair<int, int> node;
int currentDistance;
int BFS(pair<int, int> start, pair<int, int> end) {
  que.push(start);
  dist.push(0);
  alreadyTaken.insert(start);
  while (!que.empty()) {
    currentNode = que.front();
    que.pop();
    currentDistance = dist.front(), dist.pop();
    if (currentNode == end) {
      return currentDistance;
    }
    for (int i = 0; i < 8; i++) {
      node.first = currentNode.first + x[i];
      node.second = currentNode.second + y[i];
      if ((nodeSet.find(node) != nodeSet.end()) &&
          (alreadyTaken.find(node) == alreadyTaken.end())) {
        alreadyTaken.insert(node);
        que.push(node);
        dist.push(currentDistance + 1);
      }
    }
  }
  return -1;
}
int main() {
  pair<int, int> start, end;
  pair<int, int> node;
  int row, f, e, n;
  cin >> start.first >> start.second >> end.first >> end.second;
  cin >> n;
  while (n--) {
    cin >> row >> f >> e;
    node.first = row;
    for (int j = f; j <= e; j++) {
      node.second = j;
      if (nodeSet.find(node) == nodeSet.end()) nodeSet.insert(node);
    }
  }
  cout << BFS(start, end) << endl;
  return 0;
}
