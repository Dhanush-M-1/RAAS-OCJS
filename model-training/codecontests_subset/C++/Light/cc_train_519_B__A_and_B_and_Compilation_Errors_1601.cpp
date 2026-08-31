#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, a, j, n;
  long long c, sum, s[3];
  cin >> n;
  for (i = 0; i < 3; i++) {
    sum = 0;
    for (j = 0; j < n - i; j++) {
      cin >> a;
      sum += a;
    }
    if (i) s[i] = c - sum;
    c = sum;
  }
  cout << s[1] << endl << s[2] << endl;
  return 0;
}
