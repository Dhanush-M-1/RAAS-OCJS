#include <bits/stdc++.h>
using namespace std;
int main(int argc, char* argv[]) {
  int n, c;
  cin >> n >> c;
  int val;
  vector<int> x;
  for (int i = 0; i < n; ++i) {
    cin >> val;
    x.push_back(val);
  }
  int res = 0;
  for (int i = 0; i < x.size() - 1; ++i) {
    int cost = x[i];
    if (cost < x[i + 1]) continue;
    cost -= x[i + 1];
    if (cost < c) continue;
    cost -= c;
    res = max(res, cost);
  }
  cout << res;
  return 0;
}
