#include <bits/stdc++.h>
using namespace std;
int main() {
  int k, len, t, cp[1009];
  bool ok, vis[1009];
  char str[1009];
  cin >> k;
  cin >> str;
  len = strlen(str);
  memset(cp, 0, sizeof(cp));
  memset(vis, 0, sizeof(vis));
  for (int i = 0; i < len; i++) {
    int t = str[i] - 'a';
    vis[t] = 1;
    cp[t]++;
  }
  ok = true;
  for (int i = 0; i < 26; i++) {
    if (vis[i] & cp[i] % k != 0) {
      ok = false;
      break;
    }
  }
  if (ok) {
    sort(str, str + len);
    for (int i = 0; i < k; i++)
      for (int j = 0; j < len; j += k) {
        cout << str[j];
      }
  } else
    printf("-1\n");
  return 0;
}
