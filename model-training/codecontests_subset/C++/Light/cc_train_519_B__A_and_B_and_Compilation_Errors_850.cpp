#include <bits/stdc++.h>
using namespace std;
int T;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n, sum1 = 0, sum2 = 0, sum3 = 0;
  cin >> n;
  for (long long i = 1; i <= (n); i++) {
    int k;
    cin >> k;
    sum1 += k;
  }
  for (long long i = 1; i <= (n - 1); i++) {
    int k;
    cin >> k;
    sum2 += k;
  }
  for (long long i = 1; i <= (n - 2); i++) {
    int k;
    cin >> k;
    sum3 += k;
  }
  cout << sum1 - sum2 << '\n' << sum2 - sum3;
  return 0;
}
