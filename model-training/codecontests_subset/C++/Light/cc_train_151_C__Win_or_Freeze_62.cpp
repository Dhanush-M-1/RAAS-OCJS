#include <bits/stdc++.h>
using namespace std;
vector<long long> v;
long long prime_factor(long long n) {
  long long i, c;
  c = 0;
  while (n % 2 == 0) {
    n = n / 2;
    c++;
    v.push_back(2);
  }
  for (i = 3; i <= sqrt(n); i += 2) {
    while (n % i == 0) {
      n = n / i;
      c++;
      v.push_back(i);
    }
  }
  if (n > 2) c++;
  return c;
}
int main() {
  long long n, cnt;
  cin >> n;
  cnt = prime_factor(n);
  if (cnt > 2) {
    cout << "1" << endl;
    cout << v[0] * v[1] << endl;
  } else if (cnt == 2)
    cout << "2" << endl;
  else {
    cout << "1" << endl;
    cout << "0" << endl;
  }
  return 0;
}
