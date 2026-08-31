#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 5;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(NULL);
  cout.tie(NULL);
  int n, x, y;
  double demo;
  cin >> n >> x >> y;
  demo = ceil(y * n / 100.0);
  if (x <= demo)
    cout << demo - x;
  else
    cout << 0;
  return 0;
}
