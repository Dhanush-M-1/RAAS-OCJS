#include <bits/stdc++.h>
using namespace std;
const int M3 = 1005;
const int M4 = 10005;
const int M5 = 100005;
const int M6 = 1000005;
const double PI = acos(-1);
const int MOD = 1e9 + 7;
int main() {
  int n, x, y;
  cin >> n >> x >> y;
  int Percentage = (y * n) / 100;
  if ((y * n) % 100 != 0) {
    Percentage++;
  }
  if (x >= Percentage) {
    cout << 0 << endl;
  } else {
    cout << Percentage - x << endl;
  }
}
