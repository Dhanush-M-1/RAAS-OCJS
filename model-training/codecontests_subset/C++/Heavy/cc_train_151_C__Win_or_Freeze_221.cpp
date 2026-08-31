#include <bits/stdc++.h>
using namespace std;
long long MOD = 1e9 + 7;
const int OO = (int)1e9 + 7;
const long long OOO = (long long)1e18 + 7;
const int MAX = 3009;
char c1, c2, c3;
string s, s1, s2, s3;
long long n, m, k, t, a, b, c, d, e, f, x, y, z, sol, ans = 0;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> n;
  vector<int> v;
  for (long long i = 2; i * i <= n; i++) {
    if ((int)v.size() > 2) break;
    while (n % i == 0) {
      v.push_back(i);
      n /= i;
    }
  }
  if (n != 1) v.push_back(n);
  if ((int)v.size() < 2)
    cout << "1\n0";
  else if ((int)v.size() < 3)
    cout << "2";
  else
    cout << "1\n" << v[0] * v[1];
  cout << "\n\n";
  return 0;
}
