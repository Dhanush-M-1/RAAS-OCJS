#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c;
  cin >> n >> c;
  int curr, prec;
  cin >> prec;
  int maxProfit = 0;
  for (int i = 2; i <= n; ++i) {
    cin >> curr;
    if (prec - curr - c > maxProfit) {
      maxProfit = prec - curr - c;
    }
    prec = curr;
  }
  cout << maxProfit;
}
