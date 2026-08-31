#include <bits/stdc++.h>
using namespace std;
int main() {
  long long x, sum = 0, sum1 = 0, sum2 = 0, y;
  cin >> x;
  for (int i = 0; i < x; i++) {
    cin >> y;
    sum += y;
  }
  for (int i = 0; i < x - 1; i++) {
    cin >> y;
    sum1 += y;
  }
  for (int i = 0; i < x - 2; i++) {
    cin >> y;
    sum2 += y;
  }
  cout << sum - sum1 << endl;
  cout << sum1 - sum2 << endl;
}
