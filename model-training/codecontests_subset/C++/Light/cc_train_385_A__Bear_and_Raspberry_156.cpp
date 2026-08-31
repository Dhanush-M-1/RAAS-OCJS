#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c;
  cin >> n >> c;
  int resp[n];
  for (int i = 0; i < n; i++) {
    cin >> resp[i];
  }
  vector<int> profit;
  for (int i = 1; i < n; i++) {
    int a = (resp[i - 1] - resp[i] - c);
    profit.push_back(a);
  }
  sort(profit.begin(), profit.end());
  if (profit[profit.size() - 1] > 0) {
    cout << profit[profit.size() - 1];
  } else {
    cout << 0;
  }
}
