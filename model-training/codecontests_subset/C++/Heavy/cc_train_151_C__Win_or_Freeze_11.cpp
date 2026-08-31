#include <bits/stdc++.h>
#pragma GCC optimize("O3")
using namespace std;
const int N = 1e5 + 5, M = 1e4 + 5, OO = 0x3f3f3f3f, MOD = 1e9 + 7;
long long n;
vector<int> factorize(long long x) {
  int d = 1;
  vector<int> ret;
  for (int i = 2; i <= sqrt(x) && (int)(ret).size() <= 3; i += d, d = 2) {
    while (x % i == 0) ret.push_back(i), x /= i;
  }
  if (x != 1) ret.push_back(x);
  return ret;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  vector<int> v = factorize(n);
  if ((int)(v).size() <= 1)
    cout << "1\n0";
  else if ((int)(v).size() == 2)
    cout << 2;
  else
    cout << 1 << endl << v[0] * v[1];
  return 0;
}
