#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, temp;
  cin >> n;
  long long int sum = 0, sum2 = 0;
  for (int i = 0; i < n; i++) {
    cin >> temp;
    sum += temp;
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> temp;
    sum2 += temp;
  }
  cout << sum - sum2 << endl;
  sum = 0;
  for (int i = 0; i < n - 2; i++) {
    cin >> temp;
    sum += temp;
  }
  cout << sum2 - sum;
  return 0;
}
