#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  int n, x, y, c = 0;
  cin >> n >> x >> y;
  double p = ceil((y * n) / 100.00);
  p = (int)p;
  c = p - x;
  if (c <= 0) c = 0;
  cout << c;
  cout << '\n';
  ;
  return 0;
}
