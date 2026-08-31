#include <bits/stdc++.h>
using namespace std;
int main() {
  int k;
  int ans1 = 0;
  int ans2 = 0;
  int ans3 = 0;
  int sum1 = 0;
  int sum2 = 0;
  int ok;
  cin >> k;
  for (int i = 0; i < k; i++) {
    cin >> ok;
    ans1 += ok;
  }
  for (int i = 0; i < k - 1; i++) {
    cin >> ok;
    ans2 += ok;
  }
  sum1 = ans1 - ans2;
  cout << sum1 << endl;
  for (int i = 0; i < k - 2; i++) {
    cin >> ok;
    ans3 += ok;
  }
  sum2 = ans2 - ans3;
  cout << sum2;
  return 0;
}
