#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c;
  cin >> n >> c;
  set<int> profit;
  vector<int> prices;
  for (int i = 0; i < n; ++i) {
    int x;
    cin >> x;
    prices.push_back(x);
  }
  for (int i = 0; i < n - 1; ++i) {
    int x;
    x = prices[i] - prices[i + 1] - c;
    profit.insert(x);
  }
  int x;
  for (int j : profit) {
    x = j;
  }
  if (x < 0) {
    cout << 0;
    return 0;
  }
  cout << x;
  return 0;
}
