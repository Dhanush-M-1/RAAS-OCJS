#include <bits/stdc++.h>
using namespace std;
const int N = (int)2e6 + 10;
const int inf = (int)2e9;
int main() {
  string s;
  int n;
  cin >> n >> s;
  int cnt[2];
  memset(cnt, 0, sizeof(cnt));
  for (int i = 0; i < n; i++) {
    if (s[i] == '8') {
      cnt[1] += 1;
    } else
      cnt[0] += 1;
  }
  int ans = 0;
  while (1) {
    if (cnt[1] <= 0) break;
    cnt[1] -= 1;
    int baki = 10;
    if (cnt[0] >= baki) {
      cnt[0] -= baki, ans += 1;
    } else {
      int need = baki - cnt[0];
      cnt[0] = 0;
      if (cnt[1] >= need) {
        ans += 1, cnt[1] -= need;
      } else {
        break;
      }
    }
  }
  cout << ans << endl;
  return 0;
}
