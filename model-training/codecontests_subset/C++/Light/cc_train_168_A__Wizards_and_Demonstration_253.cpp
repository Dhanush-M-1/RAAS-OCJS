#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  double n, m, p;
  cin >> n >> m >> p;
  double need = n / 100 * p;
  double o = 0;
  cout << max(o, ceil(need - m));
  return 0;
}
