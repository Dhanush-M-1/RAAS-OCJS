#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c;
  cin >> n >> c;
  auto info = vector<int>(n);
  for (int x = 0; x < n; x++) cin >> info[x];
  int Max = 0;
  for (int x = 0; x < n - 1; x++) {
    int profit = (info[x] - info[x + 1] - c);
    Max = max(Max, profit);
  }
  cout << Max << endl;
  return 0;
}
