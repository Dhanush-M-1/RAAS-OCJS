#include <bits/stdc++.h>
using namespace std;
bool isPrime(long long x) {
  for (int i = 2; i * i <= x; i++)
    if (x % i == 0) return false;
  return true;
}
int main() {
  long long n, N, cnt = 0, first = 0;
  vector<long long> vec;
  cin >> n;
  N = n;
  while (n % 2 == 0) vec.push_back(2), n /= 2;
  for (int i = 3; i <= sqrt(n); i += 2)
    while (n % i == 0) vec.push_back(i), n /= i;
  if (!vec.size() || isPrime(N)) return cout << 1 << '\n' << (long long)0, 0;
  if (n != 1) vec.push_back(n);
  if (vec.size() == 2) return cout << 2, 0;
  return cout << 1 << '\n' << vec[0] * vec[1] << '\n', 0;
}
