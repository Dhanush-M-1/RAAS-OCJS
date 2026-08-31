#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  string ans1, ans2;
  stringstream t1, t2;
  scanf("%d", &n);
  ans1 = ans2 = "0";
  int xx = 0, yy = 0, dx, dy;
  for (int i = 0; i < n; i++) {
    int x, y, r;
    cin >> x >> y >> r;
    if (x & 1) x--;
    if (y & 1) y--;
    dx = x - xx;
    dy = y - yy;
    t1.str("");
    t2.str("");
    t1 << (dx >= 0 ? '+' : '-') << "(" << abs(dx / 2) << "*((abs((t-" << i
       << "))-abs((t-" << i + 1 << ")))+1))";
    t2 << (dy >= 0 ? '+' : '-') << "(" << abs(dy / 2) << "*((abs((t-" << i
       << "))-abs((t-" << i + 1 << ")))+1))";
    ans1 = "(" + ans1 + t1.str() + ")";
    ans2 = "(" + ans2 + t2.str() + ")";
    xx = x;
    yy = y;
  }
  cout << ans1 << endl;
  cout << ans2 << endl;
  return 0;
}
