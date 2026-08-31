#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  cin >> n >> x >> y;
  double need = (double)(n * y) / 100;
  int people = ceil(need);
  int ans = people - x;
  if (ans < 0) {
    cout << 0;
  } else {
    cout << ans;
  }
  return 0;
}
