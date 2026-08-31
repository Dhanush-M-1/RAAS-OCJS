#include <bits/stdc++.h>
using namespace std;
const double pi = acos(-1.0);
const double EPS = 1e-9;
const int BIG_PRIME7 = 1000000007;
const int BIG_PRIME9 = 1000000009;
char ch;
long long i, j, n, m, k;
long long N, C;
long long arr[1000];
long long q;
vector<long long> p;
bool isPrime(long long x) {
  long long i = 0;
  if (x == 2) return true;
  if (x % 2 == 0) return false;
  for (i = 3; i * i <= x; i += 2) {
    if (x % i == 0) return false;
  }
  return true;
}
bool hasAllprimes(long long x) {
  if (isPrime(x)) return false;
  for (long long i = 2; i * i <= x; i++) {
    if (x % i == 0) {
      if (!isPrime(i) || !isPrime(x / i)) return false;
    }
  }
  return true;
}
int main() {
  cin >> q;
  if (q == 1 || isPrime(q)) {
    cout << "1" << endl;
    cout << "0" << endl;
    return 0;
  }
  for (long long i = 2; i * i <= q; i++) {
    if (q % i == 0) {
      p.push_back(i);
      p.push_back(q / i);
    }
  }
  for (long long i = 0; i < p.size(); i++) {
    if (hasAllprimes(p[i])) {
      cout << "1" << endl;
      cout << p[i] << endl;
      return 0;
    }
  }
  cout << "2" << endl;
  return 0;
}
