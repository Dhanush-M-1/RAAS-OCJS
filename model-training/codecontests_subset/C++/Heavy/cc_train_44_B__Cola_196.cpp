#include <bits/stdc++.h>
using namespace std;
static const double EPS = 1e-12;
int bots[3];
long long mem[10001][3];
long long solve(int left, int cur) {
  if (cur == 3) return left == 0 ? 1LL : 0LL;
  if (left < 0) return 0LL;
  long long &ret = mem[left][cur];
  if (ret < 0LL) {
    ret = 0LL;
    if (cur == 0) {
      for (int i = 0; i <= bots[0]; i += 2) {
        ret += solve(left - i / 2, cur + 1);
      }
    } else if (cur == 1) {
      for (int i = 0; i <= bots[1]; ++i) {
        ret += solve(left - i, cur + 1);
      }
    } else {
      assert(cur == 2);
      for (int i = 0; i <= bots[2]; ++i) {
        ret += solve(left - 2 * i, cur + 1);
      }
    }
  }
  return ret;
}
int main(void) {
  int n;
  cin >> n;
  cin >> bots[0] >> bots[1] >> bots[2];
  for (int i = 0; i < (10001); ++i)
    for (int j = 0; j < (3); ++j) mem[i][j] = -1LL;
  cout << solve(n, 0) << endl;
  return 0;
}
