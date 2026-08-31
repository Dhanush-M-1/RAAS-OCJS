#include <bits/stdc++.h>
#pragma GCC optimize("O3")
using namespace std;
double pi = 3.1415926535898;
string ys = "YES\n";
string no = "NO\n";
const double EPS = 1e-6;
const int inf = 1 << 20;
const long long M = 1e9 + 7;
int n, x;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ;
  cin >> n;
  int mxx = 0;
  for (int i = 1; i <= int(n); ++i) {
    cin >> x;
    mxx = max(mxx, min(x - 1, 1000000 - x));
  }
  cout << mxx;
  return 0;
}
