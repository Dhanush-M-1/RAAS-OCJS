#include <bits/stdc++.h>
using namespace std;
int main() {
  int x, n, sum = 0, mx = -1, resultK = 0;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> x;
    mx = max(mx, x);
    sum += x;
  }
  resultK = mx;
  while (true) {
    if (resultK * n - sum > sum) break;
    resultK++;
  }
  cout << resultK;
  return 0;
}
