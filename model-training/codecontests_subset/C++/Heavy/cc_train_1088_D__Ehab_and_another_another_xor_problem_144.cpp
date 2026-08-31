#include <bits/stdc++.h>
using namespace std;
int dx[] = {0, 1, 0, -1};
int dy[] = {-1, 0, 1, 0};
const long long int MAXN = (long long int)1e6 + 20;
const long long int N = (long long int)1e5 + 10;
const long long int MOD = (long long int)1e9 + 7;
long long int query(long long int c, long long int d) {
  cout << "? " << c << " " << d << endl;
  long long int ans;
  cin >> ans;
  return ans;
}
void solve() {
  long long int a = 0, b = 0;
  long long int bigger = query(0, 0);
  for (long long int i = 29; i >= 0; --i) {
    long long int frst = query(a | (1 << i), b);
    long long int sec = query(a, b | (1 << i));
    if (frst == sec) {
      if (bigger == 1) {
        a |= (1 << i);
      } else {
        b |= (1 << i);
      }
      bigger = frst;
    } else if (frst == -1) {
      a |= (1 << i);
      b |= (1 << i);
    }
  }
  cout << "! " << a << " " << b << endl;
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  solve();
  return 0;
}
