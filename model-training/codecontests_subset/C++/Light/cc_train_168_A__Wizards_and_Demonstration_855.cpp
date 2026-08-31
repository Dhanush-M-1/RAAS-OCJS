#include <bits/stdc++.h>
using namespace std;
signed main() {
  long long n, x, y;
  cin >> n >> x >> y;
  long long per = x * 100 / n;
  long long cnt = x;
  while (per < y) {
    cnt++;
    per = cnt * 100 / n;
  }
  cout << cnt - x;
}
