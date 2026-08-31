#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, a, sum, sum1, sum2;
  sum = sum1 = sum2 = 0;
  cin >> n;
  for (long long i = 0; i < n; i++) {
    scanf("%lld", &a);
    sum += a;
  }
  for (long long i = 0; i < n - 1; i++) {
    scanf("%lld", &a);
    sum1 += a;
  }
  for (long long i = 0; i < n - 2; i++) {
    scanf("%lld", &a);
    sum2 += a;
  }
  cout << sum - sum1 << endl;
  cout << sum1 - sum2 << endl;
  return 0;
}
