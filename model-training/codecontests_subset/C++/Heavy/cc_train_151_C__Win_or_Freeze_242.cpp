#include <bits/stdc++.h>
using namespace std;
long long _sieve_size;
bitset<10000010> bs;
vector<int> primes;
void sieve(long long upperbound) {
  _sieve_size = upperbound + 1;
  bs.set();
  bs[0] = bs[1] = 0;
  for (long long i = 2; i <= _sieve_size; i++) {
    if (bs[i]) {
      for (long long j = i * i; j <= _sieve_size; j += i) bs[j] = 0;
      primes.push_back((int)i);
    }
  }
}
int main() {
  sieve(3200000);
  std::ios::sync_with_stdio(0);
  cin.tie(0);
  long long q;
  cin >> q;
  long long result = 1;
  long long aux;
  bool flag = false;
  if (q == 1) flag = true;
  int div = 0;
  for (int i = 0; i < primes.size(); i++) {
    aux = (long long)primes[i];
    while (q % aux == 0) {
      q /= aux;
      if (div <= 1) result *= aux;
      div++;
    }
    if (aux > q) break;
  }
  if (q != 1) {
    if (div <= 1) result *= aux;
    div++;
  }
  if (div == 1) flag = true;
  if (flag) {
    cout << "1\n0\n";
  } else {
    if (div == 2) {
      cout << "2\n";
    } else {
      cout << "1\n" << result << "\n";
    }
  }
  return 0;
}
