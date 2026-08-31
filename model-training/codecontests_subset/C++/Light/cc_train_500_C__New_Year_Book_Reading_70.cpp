#include <bits/stdc++.h>
using namespace std;
int gcd(int a, int b) {
  int c;
  while (a != 0) {
    c = a;
    a = b % a;
    b = c;
  }
  return b;
}
bool isPrime[100000 + 5];
vector<long long> seieve(long long maxPrime) {
  vector<long long> primes;
  for (long long i = 0; i <= maxPrime; i++) {
    isPrime[i] = true;
  }
  isPrime[1] = false;
  for (long long i = 2; i <= maxPrime; i++) {
    if (isPrime[i]) {
      primes.push_back(i);
      for (long long j = 2; j * i <= maxPrime; j++) {
        isPrime[i * j] = false;
      }
    }
  }
  return primes;
}
int w[505], b[1005];
int main() {
  ios_base::sync_with_stdio(false);
  int n, m;
  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    cin >> w[i];
  }
  for (int i = 0; i < m; i++) {
    cin >> b[i];
  }
  int tong = 0;
  map<int, int> check;
  for (int i = m - 1; i >= 0; i--) {
    check.clear();
    for (int j = i - 1; j >= 0; j--) {
      if (b[i] == b[j]) break;
      if (check.count(b[j]) == 0) {
        tong += w[b[j] - 1];
        check[b[j]] = 1;
      }
    }
  }
  cout << tong << endl;
  return 0;
}
