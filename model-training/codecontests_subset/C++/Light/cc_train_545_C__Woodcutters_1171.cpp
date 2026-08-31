#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x[100000][2];
  cin >> n;
  if (n == 1) {
    cout << 1;
    return 0;
  }
  for (int i = 0; i < n; i++) {
    cin >> x[i][0] >> x[i][1];
  }
  int count = 0;
  for (int i = 1; i < n - 1; i++) {
    if (x[i][0] - x[i][1] > x[i - 1][0]) {
      count++;
    } else if (x[i][1] + x[i][0] < x[i + 1][0]) {
      count++;
      x[i][0] = x[i][1] + x[i][0];
    }
  }
  cout << count + 2;
  return 0;
}
