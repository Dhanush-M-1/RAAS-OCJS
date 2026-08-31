#include <bits/stdc++.h>
using namespace std;
int xs, ys, xf, yf, n, r, a, b;
set<pair<int, int> > se;
map<pair<int, int>, int> ma;
queue<pair<int, int> > q;
vector<pair<int, int> > go;
int main() {
  cin >> xs >> ys >> xf >> yf;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> r >> a >> b;
    for (int j = a; j <= b; j++) {
      se.insert(make_pair(r, j));
    }
  }
  ma[make_pair(xs, ys)] = 0;
  q.push(make_pair(xs, ys));
  for (int i = -1; i < 2; i++) {
    for (int j = -1; j < 2; j++) {
      if ((i == 0) && (j == 0)) continue;
      go.push_back(make_pair(i, j));
    }
  }
  while (!q.empty()) {
    pair<int, int> v = q.front();
    int d = ma[v];
    q.pop();
    for (int i = 0; i < go.size(); i++) {
      v.first += go[i].first;
      v.second += go[i].second;
      if (!ma.count(v) && (se.find(v) != se.end())) {
        ma[v] = d + 1;
        q.push(v);
      }
      v.first -= go[i].first;
      v.second -= go[i].second;
    }
  }
  if (ma.count(make_pair(xf, yf))) {
    cout << ma[make_pair(xf, yf)] << endl;
  } else {
    cout << "-1" << endl;
  }
  return 0;
}
