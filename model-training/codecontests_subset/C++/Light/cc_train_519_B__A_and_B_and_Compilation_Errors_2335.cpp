#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int temp, sum1 = 0, sum2 = 0, sum3 = 0;
  for (int i = 0; i < n; i++) {
    cin >> temp;
    sum1 += temp;
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> temp;
    sum2 += temp;
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> temp;
    sum3 += temp;
  }
  cout << sum1 - sum2 << endl << sum2 - sum3 << endl;
}
