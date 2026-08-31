#include <bits/stdc++.h>
using namespace std;
int main() {
  cin.sync_with_stdio(false);
  cin.tie(nullptr);
  int n;
  cin >> n;
  string X = "0";
  string Y = "0";
  int px = 0;
  int py = 0;
  for (int i = 0; i < n; ++i) {
    int x, y, r;
    cin >> x >> y >> r;
    if (x & 1) --x;
    if (y & 1) --y;
    int dx = x - px;
    int dy = y - py;
    stringstream xss, yss;
    xss << (dx >= 0 ? '+' : '-') << "(" << abs(dx / 2) << "*((abs((t-" << i
        << "))-abs((t-" << (i + 1) << ")))+1))";
    yss << (dy >= 0 ? '+' : '-') << "(" << abs(dy / 2) << "*((abs((t-" << i
        << "))-abs((t-" << (i + 1) << ")))+1))";
    X = "(" + X + xss.str() + ")";
    Y = "(" + Y + yss.str() + ")";
    px += dx;
    py += dy;
  }
  cout << X << "\n";
  cout << Y << "\n";
  return 0;
}
