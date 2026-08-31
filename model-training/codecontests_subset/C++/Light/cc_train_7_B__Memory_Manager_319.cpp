#include <bits/stdc++.h>
using namespace std;
long long storage[102];
void solve() {
  long long t, m;
  cin >> t >> m;
  long long id = 0;
  for (long long i = 0; i < t; i++) {
    string s;
    cin >> s;
    if (s[0] == 'a') {
      long long t;
      cin >> t;
      long long i, j;
      for (i = 0, j = -1; i < m; i++) {
        if (!storage[i] && i - j >= t)
          break;
        else if (storage[i])
          j = i;
      }
      if (i < m) {
        cout << ++id << "\n";
        for (++j; j <= i; j++) storage[j] = id;
      } else
        cout << "NULL"
             << "\n";
    } else if (s[0] == 'e') {
      long long t;
      cin >> t;
      long long i = 0, j = 0;
      for (i = j = 0; i < m; i++)
        if (storage[i] == t) storage[i] = 0, j = 1;
      if (!j or t == 0) {
        cout << "ILLEGAL_ERASE_ARGUMENT"
             << "\n";
      }
    } else {
      for (long long i = 0, j = 0; i < m; i++) {
        if (storage[i]) {
          long long t = storage[i];
          storage[i] = 0, storage[j++] = t;
        }
      }
    }
  }
}
signed main() {
  ios::sync_with_stdio(0);
  cin.tie(NULL);
  cout.tie(NULL);
  long long t = 1;
  while (t--) {
    solve();
  }
}
