#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, sum = 0, max_1 = 0;
  int a[105];
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    sum += a[i];
    max_1 = max(max_1, a[i]);
  }
  for (int i = max_1;; i++) {
    if (n * i - sum > sum) {
      cout << i << endl;
      break;
    }
  }
  return 0;
}
