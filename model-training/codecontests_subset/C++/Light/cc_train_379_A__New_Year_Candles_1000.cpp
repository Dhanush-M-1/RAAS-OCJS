#include <bits/stdc++.h>
using namespace std;
const int INF = 0x7fffffff;
const int MINF = 0x80000000;
const long long mod = 1000000007;
const int cons = 100001;
int main() {
  int a, b;
  cin >> a >> b;
  int ans = a;
  int tmp;
  int tm;
  while (1) {
    tmp = a / b;
    if (!tmp) break;
    tm = a % b;
    ans += tmp;
    a = tmp + tm;
  }
  cout << ans << endl;
  return 0;
}
