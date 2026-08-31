#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c;
  cin >> n >> c;
  int last, current;
  cin >> last;
  int max_profit = 0;
  for (int i = 1; i < n; i++) {
    cin >> current;
    max_profit = max(max_profit, last - current - c);
    last = current;
  }
  cout << max_profit << endl;
  return 0;
}
