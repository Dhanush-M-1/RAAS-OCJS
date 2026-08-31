#include <bits/stdc++.h>
using namespace std;
void debug() {
  cout << fixed << setprecision(0);
  ios::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);
}
double const EPS = 1e-8, PI = acos(-1);
const int N = 1e8 + 9, OO = 1e9 + 9;
bool isPrime(long long x) {
  if (x == 2) return 1;
  if (x % 2 == 0) return 0;
  for (long long i = 3; i * i <= x; i += 2) {
    if (x % i == 0) return 0;
  }
  return 1;
}
vector<int> primVec;
int main() {
  debug();
  long long n;
  cin >> n;
  if (isPrime(n)) {
    cout << 1 << endl;
    cout << 0;
    return 0;
  }
  for (long long i = 2; i * i <= n; ++i) {
    while (n % i == 0) {
      n /= i;
      primVec.push_back(i);
    }
  }
  if (n > 1) primVec.push_back(n);
  if (primVec.size() == 2)
    cout << 2;
  else {
    cout << 1 << endl;
    cout << primVec[0] * primVec[1];
  }
  return 0;
}
