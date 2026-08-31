#include <bits/stdc++.h>
using namespace std;
const int INF = 0x7fffffff;
const int MINF = 0x80000000;
const long long mod = 1000000007;
const int cons = 100001;
int main() {
  int a, b;
  scanf("%d%d", &a, &b);
  int tmp;
  int tmpm;
  int ans = a;
  while (1) {
    tmp = a / b;
    if (tmp == 0) break;
    tmpm = a % b;
    a = tmp + tmpm;
    ans += tmp;
  }
  cout << ans << endl;
  return 0;
}
