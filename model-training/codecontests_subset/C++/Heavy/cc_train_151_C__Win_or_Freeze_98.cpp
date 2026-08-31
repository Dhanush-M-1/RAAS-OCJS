#include <bits/stdc++.h>
using namespace std;
const long long INF = 1e6 + 5;
const long long MAX = 1e7 + 5;
const double pi = 3.14159265359;
bitset<10000007> bs;
vector<long long> prims;
void sieve(long long n) {
  bs.set();
  bs[0] = 0;
  bs[1] = 0;
  for (long long i = 2; i < n; i++) {
    if (bs[i]) {
      prims.push_back(i);
      for (long long j = i * i; j < n; j += i) bs[j] = 0;
    }
  }
}
bool isPrime(long long a) {
  if (a < 10000000) return bs[a];
  long long b = sqrt(a) + 2;
  for (int i = 0; i < prims.size(); i++) {
    if (prims[i] > b)
      return true;
    else if (a % prims[i] == 0)
      return false;
  }
}
int main() {
  ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  long long n;
  cin >> n;
  sieve(10000000);
  if (isPrime(n) || n == 1) {
    return cout << 1 << "\n" << 0, 0;
  }
  vector<long long> pr;
  int i = 0;
  while (n > 1) {
    long long div = prims[i++];
    while (n > 1 && n % div == 0) {
      n /= div;
      pr.push_back(div);
    }
    if (i == (int)prims.size()) {
      pr.push_back(n);
      break;
    }
  }
  if (pr.size() == 2) {
    cout << 2;
  } else {
    cout << 1 << endl;
    cout << pr[0] * pr[1];
  }
}
