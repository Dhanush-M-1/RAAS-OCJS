#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  long long sum1 = 0, sum2 = 0;
  long temp;
  for (int i = 0; i < n; i++) {
    cin >> temp;
    sum1 += temp;
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> temp;
    sum2 += temp;
  }
  cout << sum1 - sum2 << "\n";
  for (int i = 0; i < n - 2; i++) {
    cin >> temp;
    sum2 -= temp;
  }
  cout << sum2;
  return (0);
}
