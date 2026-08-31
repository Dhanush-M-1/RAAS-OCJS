#include <bits/stdc++.h>
using namespace std;
const int MaxN = 100 + 10;
int x[MaxN];
int main() {
  int n, c;
  cin >> n >> c;
  for (int i = 0; i < n; ++i) cin >> x[i];
  int mx = 0;
  for (int i = 0; i < n - 1; ++i) mx = max(mx, x[i] - x[i + 1] - c);
  cout << mx;
}
