#include <bits/stdc++.h>
using namespace std;
void upgrade() {
  ios_base::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL);
}
int main() {
  upgrade();
  int tc;
  cin >> tc;
  while (tc--) {
    long long n, l, r;
    cin >> n >> l >> r;
    long long add = 2 * n - 2, cnt = 0, h = 1;
    while (add != 0 && cnt + add < l) {
      cnt += add;
      add -= 2;
      h++;
    }
    if (add == 0) {
      cout << 1 << '\n';
      continue;
    }
    long long diff = l - cnt;
    bool f = (diff % 2) == 1;
    long long st = (diff - 1) / 2 + h + 1;
    for (int i = 0; i < r - l + 1; i++) {
      if (f) {
        cout << h << ' ';
      } else {
        cout << st << ' ';
        if (st == n) {
          h++;
          st = h + 1;
          if (h == n && i != r - l) {
            cout << 1;
            break;
          }
        } else
          st++;
      }
      f = !f;
    }
    cout << '\n';
  }
}
