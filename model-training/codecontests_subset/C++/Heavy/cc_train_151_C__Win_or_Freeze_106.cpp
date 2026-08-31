#include <bits/stdc++.h>
using namespace std;
const int OO = 0x3f3f3f3f;
const double eps = (1e-10);
bool isPrime(long long n) {
  if (n < 2) return 0;
  for (long long i = 2; i * i <= n; i++)
    if (n % i == 0) return 0;
  return 1;
}
vector<long long> getFactors(long long n) {
  vector<long long> ret;
  long long tmp = n, cnt = 1;
  for (long long i = 2; i * i <= n; i++) {
    long long x = 1;
    while (tmp % i == 0) {
      ret.push_back(i);
      tmp /= i;
      ++x;
    }
    cnt *= x;
  }
  if (tmp != 1) {
    ret.push_back(tmp);
    cnt *= 2;
  }
  return ret;
}
int main() {
  cout.precision(10);
  long long x;
  cin >> x;
  if (x == 1) return puts("1\n0");
  vector<long long> v = getFactors(x);
  sort(v.begin(), v.end());
  if (v.size() == 2) return puts("2");
  if (v.size() == 1) return puts("1\n0");
  puts("1");
  cout << v[0] * v[1];
  return 0;
}
