#include <bits/stdc++.h>
using namespace std;
const double eps = 1e-6;
const int maxn = 1e6 + 10;
int n, x[maxn], y[maxn], m;
void solve1() {
  for (int i = 1; i < n; i++) cout << '(';
  for (int i = 0; i < n; i++) {
    if (i >= 1) cout << '+';
    printf("(%d*((1-abs((t-%d)))+abs((abs((t-%d))-1))))", x[i] / 2, i, i);
    if (i >= 1) cout << ')';
  }
}
void solve2() {
  for (int i = 1; i < n; i++) cout << '(';
  for (int i = 0; i < n; i++) {
    if (i >= 1) cout << '+';
    printf("(%d*((1-abs((t-%d)))+abs((abs((t-%d))-1))))", y[i] / 2, i, i);
    if (i >= 1) cout << ')';
  }
}
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) cin >> x[i] >> y[i] >> m;
  solve1();
  cout << endl;
  solve2();
  return 0;
}
