#include <bits/stdc++.h>
using namespace std;
const pair<int, int> dir[] = {
    make_pair(-1, -1), make_pair(-1, 0), make_pair(-1, 1), make_pair(0, -1),
    make_pair(0, 1),   make_pair(1, -1), make_pair(1, 0),  make_pair(1, 1)};
int n;
pair<int, int> source, target;
set<pair<int, int> > mapping;
map<pair<int, int>, int> dist;
__inline pair<int, int> operator+(const pair<int, int> &a,
                                  const pair<int, int> &b) {
  return make_pair(a.first + b.first, a.second + b.second);
}
int main(void) {
  ios::sync_with_stdio(false);
  cin >> source.first >> source.second >> target.first >> target.second;
  cin >> n;
  for (int i = 0; i < n; ++i) {
    int x, left, right;
    cin >> x >> left >> right;
    for (int y = left; y <= right; ++y) {
      mapping.insert(make_pair(x, y));
    }
  }
  vector<pair<int, int> > queue;
  queue.push_back(source);
  dist[source] = 0;
  for (int head = 0; head < (int)queue.size(); ++head) {
    pair<int, int> x = queue[head];
    for (int i = 0; i < 8; ++i) {
      pair<int, int> y = x + dir[i];
      if (mapping.count(y) && !dist.count(y)) {
        dist[y] = dist[x] + 1;
        queue.push_back(y);
      }
    }
  }
  if (!dist.count(target)) {
    cout << -1 << endl;
  } else {
    cout << dist[target] << endl;
  }
}
