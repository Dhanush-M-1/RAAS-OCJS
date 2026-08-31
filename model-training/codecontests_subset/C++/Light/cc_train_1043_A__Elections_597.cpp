#include <bits/stdc++.h>
using namespace std;
int main() {
  {
    cin.sync_with_stdio(0);
    cout.sync_with_stdio(0);
    cin.tie(0);
    cout.tie();
  }
  {}
  int n;
  cin >> n;
  int Min = 0;
  int sum = 0;
  for (int i = 0; i < n; i++) {
    int x;
    cin >> x;
    sum += x;
    Min = max(Min, x);
  }
  for (int i = Min;; i++) {
    if (n * i - sum > sum) {
      cout << i;
      return 0;
    }
  }
  return 0;
}
