#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int a, b, c;
  cin >> a >> b >> c;
  int rel_vel = a - b;
  int dis = c * rel_vel;
  int ti = ceil(dis / (b * 1.0));
  cout << ti;
  return 0;
}
