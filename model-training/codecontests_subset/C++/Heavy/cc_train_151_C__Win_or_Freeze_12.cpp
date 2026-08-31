#include <bits/stdc++.h>
using namespace std;
vector<long long> primes;
const int mxN = 4e6 + 5;
bool vis[mxN];
long long q;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  for (int i = 2; i < mxN; i++) {
    if (vis[i]) continue;
    primes.push_back(i);
    for (int j = i; j < mxN; j += i) {
      vis[j] = true;
    }
  }
  cin >> q;
  long long q1 = q;
  vector<long long> P;
  for (auto x : primes) {
    while (q1 % x == 0) {
      P.push_back(x);
      q1 /= x;
    }
  }
  if (q1 > 1) P.push_back(q1);
  if (P.size() <= 1) {
    cout << 1 << endl;
    cout << 0 << endl;
    return 0;
  }
  if (P.size() == 2) {
    cout << 2 << endl;
    return 0;
  }
  long long x = P[0] * P[1];
  cout << 1 << endl;
  cout << x << endl;
  return 0;
}
