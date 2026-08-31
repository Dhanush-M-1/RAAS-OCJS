#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  double n, x, y;
  cin >> n >> x >> y;
  double t = (n * y) / 100;
  long long t2 = ceil(t);
  long long t3 = t2 - x;
  if (t3 < 0)
    cout << 0;
  else
    cout << t3;
  return 0;
}
