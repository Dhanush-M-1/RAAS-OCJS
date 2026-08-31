#include <bits/stdc++.h>
using namespace std;
int dx[] = {0, 1, -1, 0};
int dy[] = {1, 0, 0, -1};
long long pw(long long b, long long p) {
  if (!p) return 1;
  long long sq = pw(b, p / 2) % 98765431;
  sq = (sq * sq) % 98765431;
  if (p % 2) sq = (sq * b) % 98765431;
  return sq;
}
const int N = 105, M = N * N;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  long long n;
  cin >> n;
  long long nn = n;
  vector<long long> v;
  if (n == 1) {
    cout << 1 << "\n" << 0;
    return 0;
  }
  for (int i = 2; i <= ceil(sqrt((long double)n)) && i != n; i++) {
    if (n % i == 0) {
      while (n % i == 0) {
        n /= i;
        v.push_back(i);
      }
    }
  }
  if (n > 1) v.push_back(n);
  if ((int)v.size() == 1 || !(int)v.size())
    cout << 1 << "\n" << 0;
  else if ((int)v.size() == 2)
    cout << 2;
  else {
    long long r = 1;
    for (int i = 0; i < (int)v.size() - 2; i++) {
      r *= v[i] * 1LL;
    }
    cout << 1 << "\n" << nn / r;
  }
  return 0;
}
