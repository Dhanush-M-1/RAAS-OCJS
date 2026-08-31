#include <bits/stdc++.h>
using namespace std;
const int MAX = 1e9 + 7;
const double PI = 3.1415926535;
void solve() {
  int n;
  cin >> n;
  int Sum = 0, Max = 0;
  for (int a = 0; a < n; a++) {
    int in;
    cin >> in;
    Sum += in;
    Max = max(Max, in);
  }
  int k = Sum * 2 / n;
  k++;
  if (k < Max) k = Max;
  cout << k;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  solve();
  cerr << endl << "Time elapsed: " << 1.0 * clock() / CLOCKS_PER_SEC << "s.\n";
  return 0;
}
