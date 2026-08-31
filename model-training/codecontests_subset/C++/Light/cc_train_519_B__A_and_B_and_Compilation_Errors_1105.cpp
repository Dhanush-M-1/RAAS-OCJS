#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int x;
  long long sum1 = 0, sum2 = 0, sum3 = 0;
  for (int i = 0; i < n; i++) {
    cin >> x;
    sum1 += x;
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> x;
    sum2 += x;
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> x;
    sum3 += x;
  }
  cout << sum1 - sum2 << endl;
  cout << sum2 - sum3 << endl;
  return 0;
}
