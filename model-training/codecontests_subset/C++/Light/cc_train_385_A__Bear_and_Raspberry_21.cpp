#include <bits/stdc++.h>
using namespace std;
const int INF = 1e9;
const int MAX_N = 100 + 10;
int n, c, x[MAX_N];
int main() {
  ios::sync_with_stdio(0);
  while (cin >> n >> c) {
    for (int i = 0; i < n; i++) {
      cin >> x[i];
    }
    int profit = 0;
    for (int i = 0; i < n - 1; i++) {
      int get = x[i];
      get -= x[i + 1];
      get -= c;
      profit = max(profit, get);
    }
    printf("%d\n", profit);
  }
  return 0;
}
