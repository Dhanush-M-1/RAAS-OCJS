#include <bits/stdc++.h>
using namespace std;
int n, m, now, x, use[110], a[110];
char s[10];
int main() {
  cin >> m >> n;
  while (m--) {
    cin >> s;
    if (s[0] == 'a') {
      use[++now] = 1;
      int ans = 0;
      cin >> x;
      int cnt = 0;
      for (register int i = 1; i <= n; i++) {
        if (!a[i])
          cnt++;
        else
          cnt = 0;
        if (cnt == x) {
          for (register int k = i; k && !a[k]; k--) a[k] = now;
          ans = now;
          break;
        }
      }
      if (!ans)
        use[now--] = 0, cout << "NULL" << endl;
      else
        cout << ans << endl;
    } else if (s[0] == 'e') {
      cin >> x;
      if (x < 1 || !use[x])
        cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
      else {
        use[x] = 0;
        for (register int i = 1; i <= n; i++)
          if (a[i] == x) a[i] = 0;
      }
    } else {
      vector<int> v;
      for (register int i = 1; i <= n; i++)
        if (a[i]) v.push_back(a[i]);
      memset(a, 0, sizeof(a));
      for (register int i = 0; i < v.size(); i++) a[i + 1] = v[i];
    }
  }
  return 0;
}
