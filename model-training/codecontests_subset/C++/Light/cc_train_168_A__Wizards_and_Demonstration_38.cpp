#include <bits/stdc++.h>
using namespace std;
class Solution {};
int main(int argc, char* argv[]) {
  ios_base::sync_with_stdio(false);
  int n, x, y;
  cin >> n >> x >> y;
  double p = (((double)(y * n)) / 100.0 - x);
  if (p < 0) p = 0;
  cout << ceil(p) << "\n";
  return 0;
}
