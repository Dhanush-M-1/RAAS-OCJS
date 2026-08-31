#include <bits/stdc++.h>
using namespace std;
const int maxn = 2000005;
int per[maxn], c[maxn];
int main() {
  int n;
  cin >> n;
  for (int i = 1; i <= n; i++) cin >> per[i];
  long long turn = 0, dis = 0;
  for (int i = 1; i <= n; i++) {
    if (per[i] >= i) {
      c[per[i] - i]++;
      turn += per[i] - i;
      dis--;
    } else {
      c[per[i] + n - i]++;
      turn += i - per[i];
      dis++;
    }
  }
  long long ret = turn;
  int ps = 0;
  for (int i = 1; i <= n; i++) {
    dis += c[i - 1] * 2 - 2;
    turn += abs(per[n - i + 1] - 1) - abs(per[n - i + 1] - n) + 1 + dis;
    if (turn < ret) {
      ret = turn;
      ps = i;
    }
  }
  cout << ret << " " << ps;
}
