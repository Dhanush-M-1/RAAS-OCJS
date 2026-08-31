#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  int n, i;
  n = 5;
  int sum = 0;
  while (n--) {
    int temp;
    cin >> temp;
    sum += temp;
  }
  int ans = sum;
  if (ans % 5 == 0 && ans != 0)
    cout << ans / 5 << endl;
  else
    cout << "-1" << endl;
  return 0;
}
