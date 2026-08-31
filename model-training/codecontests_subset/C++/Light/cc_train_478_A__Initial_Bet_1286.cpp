#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n;
  n = 5;
  long long sum = 0;
  while (n) {
    n--;
    long long x;
    cin >> x;
    sum += x;
  }
  if (sum % 5 == 0 && sum != 0)
    cout << sum / 5;
  else
    cout << -1;
  return 0;
}
