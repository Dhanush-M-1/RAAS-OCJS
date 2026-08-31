#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  int n, x;
  double y;
  cin >> n >> x >> y;
  y /= 100.0;
  int target = ceil(n * y);
  cout << max(target - x, 0);
}
