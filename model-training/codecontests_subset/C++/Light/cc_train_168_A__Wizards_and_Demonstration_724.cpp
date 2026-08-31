#include <bits/stdc++.h>
using namespace std;
int dcmp(double x, double y) {
  return fabs(x - y) <= 1e-9 ? 0 : x < y ? -1 : 1;
};
int n, x, y, p;
double ans;
void read() { cin >> n >> x >> y; }
void solve() {
  ans = n * y;
  p = ceil(ans / 100.0);
  if (p - x <= 0) {
    cout << 0 << '\n';
  } else {
    cout << p - x << '\n';
  }
}
int main() {
  read();
  solve();
}
