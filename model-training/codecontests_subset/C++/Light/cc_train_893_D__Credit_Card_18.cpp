#include <bits/stdc++.h>
using namespace std;
int n, d, t, tong = 0, dem = 0, du = 0;
bool co = false;
int main() {
  cin >> n >> d;
  for (int i = 0; i < n; i++) {
    cin >> t;
    if (!t)
      tong < 0 ? du = 0, tong = d, co = true, dem++ : co = false,
                 du = max(du, 0);
    du += t;
    co == true ? tong = min(tong + t, d) : tong += t;
    if (du > d) {
      cout << -1 << endl;
      return 0;
    }
  }
  cout << dem << endl;
  return 0;
}
