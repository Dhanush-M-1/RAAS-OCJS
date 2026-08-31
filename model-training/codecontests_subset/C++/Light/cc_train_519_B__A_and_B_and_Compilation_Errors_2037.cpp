#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n, sum1 = 0, sum2 = 0, ans1, ans2;
  long long int c;
  cin >> n;
  for (long long int i = 0; i < n; i++) {
    cin >> c;
    sum1 += c;
  }
  for (long long int i = 0; i < n - 1; i++) {
    cin >> c;
    sum2 += c;
  }
  ans1 = sum1 - sum2;
  sum1 = 0;
  for (long long int i = 0; i < n - 2; i++) {
    cin >> c;
    sum1 += c;
  }
  ans2 = sum2 - sum1;
  cout << ans1 << endl;
  cout << ans2 << endl;
}
