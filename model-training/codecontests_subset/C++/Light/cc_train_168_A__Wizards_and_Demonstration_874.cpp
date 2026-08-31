#include <bits/stdc++.h>
using namespace std;
const int OO = (int)2e9;
const double PI = 2 * acos(0.0);
const double EPS = 1e-9;
int dcmp(double a, double b) { return fabs(a - b) <= EPS ? 0 : a > b ? 1 : 2; }
int DI[] = {-1, 0, 1, 0, 1, -1, -1, 1};
int DJ[] = {0, 1, 0, -1, 1, -1, 1, -1};
int main() {
  long long n, m, y;
  cin >> n >> m >> y;
  long long need = ceil((double)(y * n) / 100.0);
  if (m > need)
    cout << 0 << endl;
  else
    cout << need - m << endl;
  return 0;
}
