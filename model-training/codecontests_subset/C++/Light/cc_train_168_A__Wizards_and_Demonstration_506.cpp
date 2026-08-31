#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using ull = unsigned long long;
using pii = pair<int, int>;
using pll = pair<ll, ll>;
const int MAXN = 1e5 + 5;
const int MOD = 1e9 + 7;
const int INF = 0x3f3f3f3f;
const long long int LLINF = 0x3f3f3f3f3f3f3f3f;
const double EPS = 1e-9;
map<ll, int> tab;
int main() {
  float n, x, y;
  cin >> n >> x >> y;
  int a = (y * n);
  if (a % 100)
    a = (a / 100) + 1 - x;
  else
    a = (a / 100) - x;
  cout << (a < 0 ? 0 : a);
  return 0;
}
