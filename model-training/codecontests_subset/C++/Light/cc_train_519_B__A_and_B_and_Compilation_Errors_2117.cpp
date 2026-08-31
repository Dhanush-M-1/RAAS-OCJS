#include <bits/stdc++.h>
using namespace std;
int main() {
  cin.tie(NULL);
  ios_base::sync_with_stdio(false);
  int n;
  cin >> n;
  long long int sum = 0;
  long long int sum1 = 0;
  long long int sum2 = 0;
  int temp;
  for (int i = 0; i < n; i++) {
    cin >> temp;
    sum += temp;
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> temp;
    sum1 += temp;
  }
  sum = sum - sum1;
  for (int i = 0; i < n - 2; i++) {
    cin >> temp;
    sum2 += temp;
  }
  sum2 = sum1 - sum2;
  cout << sum << '\n' << sum2;
  return 0;
}
