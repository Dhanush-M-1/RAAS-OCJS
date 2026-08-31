#include <bits/stdc++.h>
using namespace std;
vector<int> primes;
using ll = long long int;
using dl = double;
bool fk[100000];
ll aarray[100000 + 10];
char magic[1][100000];
const int N = 2e5 + 10;
int main() {
  ios_base::sync_with_stdio(false);
  string str, ptr;
  ll n, a, b, ans = 0, i, A = 0, B, C, D, E, cst, c, cd, d, j, k, x0, t;
  vector<ll> v;
  vector<ll> ar, ba, ca;
  cin >> n;
  ll asum = 0, bsum = 0, csum = 0;
  for (i = 1; i <= n; i++) {
    cin >> a;
    asum += a;
  }
  for (i = 1; i < n; i++) {
    cin >> a;
    bsum += a;
  }
  for (i = 1; i < n - 1; i++) {
    cin >> a;
    csum += a;
  }
  cout << asum - bsum << " " << bsum - csum << endl;
}
