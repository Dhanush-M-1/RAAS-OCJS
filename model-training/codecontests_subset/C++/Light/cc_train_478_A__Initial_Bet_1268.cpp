#include <bits/stdc++.h>
using namespace std;
int main() {
  int c[5];
  for (int i = 0; i < 5; i++) cin >> c[i];
  if ((c[0] + c[1] + c[2] + c[3] + c[4]) % 5 ||
      (c[0] + c[1] + c[2] + c[3] + c[4]) == 0)
    cout << "-1";
  else {
    int avg = (c[0] + c[1] + c[2] + c[3] + c[4]) / 5, sum = 0;
    for (int i = 0; i < 5; i++) sum += (c[i] - avg);
    if (sum == 0)
      cout << avg;
    else
      cout << "-1";
  }
  return 0;
}
