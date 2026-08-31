#include <bits/stdc++.h>
using namespace std;
const long double epsilon = 1e-9;
int cxG, cyG;
set<pair<int, int> > reached;
void makeMove(int x, int y) {
  queue<pair<int, int> > toMove;
  toMove.push(make_pair(x, y));
  pair<int, int> cur;
  while (!toMove.empty()) {
    cur = toMove.front();
    toMove.pop();
    x = cur.first;
    y = cur.second;
    if (reached.find(make_pair(y, -x)) == reached.end()) {
      reached.insert(make_pair(y, -x));
      toMove.push(make_pair(y, -x));
    }
    if (abs(x + cxG) < 200 && abs(y + cyG) < 200 &&
        reached.find(make_pair(x + cxG, y + cyG)) == reached.end()) {
      reached.insert(make_pair(x + cxG, y + cyG));
      toMove.push(make_pair(x + cxG, y + cyG));
    }
  }
}
void tester() {
  int ax, ay;
  cin >> ax >> ay >> cxG >> cyG;
  reached.insert(make_pair(ax, ay));
  makeMove(ax, ay);
  for (int i = 0; i < 20; i++) {
    for (int j = 0; j < 20; j++) {
      if (reached.find(make_pair(i, j)) == reached.end())
        cout << " 0";
      else
        cout << " 1";
    }
    cout << endl;
  }
}
bool tester(int ax, int ay, int bx, int by, int cx, int cy) {
  cxG = cx;
  cyG = cy;
  reached.insert(make_pair(ax, ay));
  makeMove(ax, ay);
  return reached.find(make_pair(bx, by)) != reached.end();
}
bool tryIt(long long x, long long y, long long bx, long long by) {
  if (bx == 0 && by == 0) {
    return x == 0 && y == 0;
  }
  if ((x * bx + y * by) % (bx * bx + by * by) != 0) {
    return false;
  }
  long long k = (x * bx + y * by) / (bx * bx + by * by);
  if (by != 0) {
    return (x - k * bx) % by == 0;
  } else
    return y % bx == 0;
}
bool solve(int ax, int ay, int bx, int by, int cx, int cy) {
  int tmp;
  while (cx < 0 || cy < 0) {
    tmp = cx;
    cx = cy;
    cy = -tmp;
  }
  for (int j = 0; j < 4; j++) {
    if (tryIt(bx - ax, by - ay, cx, cy)) {
      return true;
    }
    tmp = ax;
    ax = ay;
    ay = -tmp;
  }
  return false;
}
int main() {
  int ax, ay, bx, by, cx, cy;
  cin >> ax >> ay >> bx >> by >> cx >> cy;
  bool does = solve(ax, ay, bx, by, cx, cy);
  if (does)
    cout << "YES" << endl;
  else
    cout << "NO" << endl;
  return 0;
}
