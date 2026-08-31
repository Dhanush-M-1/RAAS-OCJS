#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, sum[3] = {0}, j, yo;
  cin >> n;
  for (i = 0; i < 3; ++i)
    for (j = 0; j < n - i; ++j) {
      cin >> yo;
      sum[i] += yo;
    }
  cout << sum[0] - sum[1] << endl;
  cout << sum[1] - sum[2];
  return 0;
}
