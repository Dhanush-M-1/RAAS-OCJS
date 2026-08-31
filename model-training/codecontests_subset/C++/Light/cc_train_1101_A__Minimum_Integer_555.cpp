#include <bits/stdc++.h>
using namespace std;
const int MOD = (int)1e9 + 7;
const int MAXN = (int)2e5 + 5;
long long T, l, r, d;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> T;
  while (T-- && cin >> l >> r >> d) {
    if (l > d)
      cout << d << endl;
    else
      cout << (r / d + 1) * d << endl;
  }
}
