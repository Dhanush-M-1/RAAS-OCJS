#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long int n;
  cin >> n;
  long long int i;
  long long int sum = 0;
  for (i = 0; i <= n - 1; i++) {
    long long int x;
    cin >> x;
    sum += x;
  }
  long long int sum1 = 0;
  for (i = 0; i <= n - 2; i++) {
    long long int x;
    cin >> x;
    sum1 += x;
  }
  cout << sum - sum1 << "\n";
  for (i = 0; i <= n - 3; i++) {
    long long int x;
    cin >> x;
    sum1 -= x;
  }
  cout << sum1;
}
