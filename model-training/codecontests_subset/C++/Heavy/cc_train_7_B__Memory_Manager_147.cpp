#include <bits/stdc++.h>
using namespace std;
int t, m, x, cnt, memo[200], pos[200], len[200], erased[200];
char s[20];
int main() {
  cin >> t >> m;
  for (int i = 1; i <= t; i++) {
    cin >> s;
    if (s[0] == 'a') {
      cin >> x;
      int flag = -1;
      for (int j = 0; j <= m - x; j++) {
        flag = j;
        for (int k = j; k < j + x; k++)
          if (memo[k] != 0) flag = -1;
        if (flag != -1) break;
      }
      if (flag == -1)
        cout << "NULL\n";
      else {
        cnt++;
        cout << cnt << endl;
        for (int k = flag; k < flag + x; k++) memo[k] = cnt;
        len[cnt] = x;
        pos[cnt] = flag;
      }
    } else if (s[0] == 'e') {
      cin >> x;
      if (x < 1 || x > cnt || erased[x])
        cout << "ILLEGAL_ERASE_ARGUMENT\n";
      else {
        erased[x] = 1;
        for (int k = pos[x]; k < pos[x] + len[x]; k++) memo[k] = 0;
      }
    } else {
      int now = 0;
      for (int i = 0; i < m; i++) {
        if (memo[i] == 0) continue;
        int tmp = memo[i];
        memo[i] = memo[now];
        memo[now] = tmp;
        pos[memo[now]] = min(pos[memo[now]], now);
        now++;
      }
    }
  }
  return 0;
}
