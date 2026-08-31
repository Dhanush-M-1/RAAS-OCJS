#include <bits/stdc++.h>
using namespace std;
const double eps = 1e-9;
const double maxn = 1e10 + 10;
const int INF = 0x3f3f3f3f;
const int mod = 1e9 + 7;
int main() {
  int n, sum = 0;
  cin >> n;
  string s;
  cin >> s;
  for (int i = 0; i <= n - 1; i++) {
    if (s[i] == '8') {
      sum++;
    }
  }
  int t = n / 11;
  cout << min(t, sum) << endl;
  return 0;
}
