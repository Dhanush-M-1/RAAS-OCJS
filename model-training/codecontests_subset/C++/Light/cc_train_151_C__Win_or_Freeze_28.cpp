#include <bits/stdc++.h>
using namespace std;
vector<int> dv;
void primeFactors(long long int n) {
  while (n % 2 == 0) {
    dv.push_back(2);
    n = n / 2;
  }
  for (long long int i = 3; i <= sqrt(n); i = i + 2) {
    while (n % i == 0) {
      dv.push_back(i);
      n = n / i;
    }
  }
  if (n > 2) dv.push_back(n);
}
int main() {
  long long int n;
  cin >> n;
  long long int nn = n;
  primeFactors(n);
  if (nn == 1 || dv.size() == 1) {
    cout << 1 << endl << 0;
    return 0;
  }
  if (dv.size() == 2) {
    cout << 2;
    return 0;
  }
  cout << 1 << endl;
  cout << dv[0] * dv[1];
  return 0;
}
