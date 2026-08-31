#include <bits/stdc++.h>
using namespace std;
double CN2(double n) { return n * (n - 1.0) / 2.0; }
bool bulbs[111];
void solve(int n, int m) {
  int x;
  int y;
  for (int i = 1; i <= n; i++) {
    cin >> x;
    for (int j = 1; j <= x; j++) {
      cin >> y;
      bulbs[y] = true;
    }
  }
  bool yes = true;
  for (int i = 1; i <= m; i++) {
    if (!bulbs[i]) {
      yes = false;
      break;
    }
  }
  if (yes)
    cout << "YES" << endl;
  else
    cout << "NO" << endl;
}
int main() {
  int n, m;
  cin >> n >> m;
  solve(n, m);
  return 0;
}
