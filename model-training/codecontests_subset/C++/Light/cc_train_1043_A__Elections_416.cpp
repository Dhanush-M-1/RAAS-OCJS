#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, max_v;
  int sum, base;
  cin >> n;
  sum = max_v = 0;
  for (int i = 0; i < n; i++) {
    int x;
    cin >> x;
    sum += x;
    max_v = max(max_v, x);
  }
  base = max_v * n - sum;
  int d = sum - base;
  int k = (sum < base ? max_v : max_v + d / n + (d % n > 0));
  while (k * n - sum <= sum) k++;
  cout << k << endl;
  return 0;
}
