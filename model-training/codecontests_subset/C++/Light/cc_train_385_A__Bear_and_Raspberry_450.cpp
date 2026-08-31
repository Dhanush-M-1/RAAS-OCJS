#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c, i, j, p = 0, q;
  cin >> n >> c;
  int x[n];
  int profit[n * n];
  for (i = 0; i < n; i++) {
    cin >> x[i];
  }
  for (i = 0; i < n - 1; i++) {
    profit[p] = x[i] - x[i + 1] - c;
    p++;
  }
  q = *max_element(profit, profit + p);
  if (q < 0)
    cout << "0";
  else
    cout << q;
}
