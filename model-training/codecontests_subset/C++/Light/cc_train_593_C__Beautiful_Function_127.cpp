#include <bits/stdc++.h>
using namespace std;
const int inf = 0x3f3f3f3f;
const int maxn = 55;
int x[maxn], y[maxn], r[maxn];
void solve(int a[], int n) {
  for (int i = 1; i < n; i++) cout << "(";
  for (int i = 0; i < n; i++) {
    if (i) cout << "+";
    cout << "(" << a[i] / 2 << "*((1-"
         << "abs((t-" << i << ")))+abs((abs((t-" << i << "))-1))))";
    if (i) cout << ")";
  }
  cout << "\n";
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) cin >> x[i] >> y[i] >> r[i];
  solve(x, n);
  solve(y, n);
  return 0;
}
