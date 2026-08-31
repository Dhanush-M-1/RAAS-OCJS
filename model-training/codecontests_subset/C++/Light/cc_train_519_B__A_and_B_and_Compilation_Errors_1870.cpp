#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  int n;
  cin >> n;
  int sum1 = 0;
  for (int i = 0; i < n; ++i) {
    int a;
    cin >> a;
    sum1 += a;
  }
  int sum2 = 0;
  for (int i = 1; i < n; ++i) {
    int a;
    cin >> a;
    sum2 = sum2 + a;
  }
  int sum3 = 0;
  for (int i = 2; i < n; ++i) {
    int a;
    cin >> a;
    sum3 += a;
  }
  cout << sum1 - sum2 << endl << sum2 - sum3;
  return 0;
}
