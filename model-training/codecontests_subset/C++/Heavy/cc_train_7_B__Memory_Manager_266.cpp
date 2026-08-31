#include <bits/stdc++.h>
using namespace std;
string type;
long long a[181], n, i, j, q, len, nom, nom1;
bool x;
bool check(long long l, long long r) {
  long long i;
  for (i = l; i <= r; i++)
    if (a[i] != 9000000000000000000LL) return 0;
  return 1;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cin >> q >> n;
  for (i = 1; i <= n; i++) a[i] = 9000000000000000000LL;
  while (q--) {
    cin >> type;
    if (type[0] == 'a') {
      cin >> len;
      x = false;
      for (i = 1; i <= n - len + 1; i++)
        if (check(i, i + len - 1)) {
          x = true;
          nom1++;
          for (j = i; j <= i + len - 1; j++) a[j] = nom1;
          break;
        }
      if (x)
        cout << nom1;
      else
        cout << "NULL";
      cout << '\n';
    } else if (type[0] == 'e') {
      cin >> nom;
      x = false;
      for (i = 1; i <= n; i++)
        if (a[i] == nom) {
          x = true;
          a[i] = 9000000000000000000LL;
        }
      if (!x) cout << "ILLEGAL_ERASE_ARGUMENT" << '\n';
    } else {
      for (i = 1; i <= n; i++)
        if (a[i] != 9000000000000000000LL) {
          nom = i;
          while (i > 1 && a[nom - 1] == 9000000000000000000LL) {
            swap(a[nom], a[nom - 1]);
            nom--;
          }
        }
    }
  }
  return 0;
}
