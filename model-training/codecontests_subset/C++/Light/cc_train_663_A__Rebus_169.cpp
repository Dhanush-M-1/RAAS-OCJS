#include <bits/stdc++.h>
using namespace std;
void solve() {
  int n, p = 0, ne = 0;
  char ch = '0';
  vector<char> ord{'+'};
  while (cin >> ch && ch != '=') {
    if (ch == '?') {
      p++;
    } else if (ch == '-') {
      ne--;
      ord.push_back('-');
    }
    if (ch == '+') {
      ord.push_back('+');
    }
  }
  cin >> n;
  if (n < p + ne + n * ne || ((p + ne) * n) + ne < n) {
    cout << "Impossible";
    return;
  }
  vector<int> ans(ord.size());
  for (int i = 0; i < ord.size(); i++) {
    ans[i] = ('+' == ord[i] ? n : 1);
  }
  int rm = (p + ne) * n;
  int f = n;
  p += ne;
  n -= ne;
  for (int i = 0; i < ord.size(); i++) {
    if (ord[i] == '-') {
      continue;
    }
    int x = min(ans[i] - 1, rm - n);
    ans[i] -= x;
    p--;
    rm -= x;
  }
  for (int i = 0; i < ord.size(); i++) {
    if (ord[i] == '+') {
      continue;
    }
    int x = min(f - 1, rm - n);
    ans[i] += x;
    p--;
    rm -= x;
  }
  cout << "Possible\n";
  for (int i = 0; i < ord.size(); i++) {
    if (!i) {
      cout << ans[i] << " ";
    } else {
      cout << ord[i] << " " << ans[i] << " ";
    }
  }
  cout << "= " << f;
}
int32_t main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  int tq = 1;
  for (; tq; tq--) {
    solve();
  }
}
