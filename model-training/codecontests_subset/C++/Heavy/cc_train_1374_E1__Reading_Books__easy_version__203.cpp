#include <bits/stdc++.h>
using namespace std;
void err(istream_iterator<string> it) {}
template <typename T, typename... Args>
void err(istream_iterator<string> it, T a, Args... args) {
  cout << *it << " = " << a << endl;
  err(++it, args...);
}
void solve() {
  int n, k;
  cin >> n >> k;
  vector<int> a, b, c;
  for (int i = 0; i < n; i++) {
    int t, al, bo;
    cin >> t >> al >> bo;
    pair<int, int> temp = make_pair(al, bo);
    if (temp == make_pair(1, 0)) {
      a.push_back(t);
    } else if (temp == make_pair(0, 1)) {
      b.push_back(t);
    } else if (temp == make_pair(1, 1)) {
      c.push_back(t);
    }
  }
  sort(a.begin(), a.end());
  sort(b.begin(), b.end());
  sort(c.begin(), c.end());
  int x1 = 0, x2 = 0, ans = 0;
  int i = 0, j = 0;
  bool ok = true;
  while (x1 < k || x2 < k) {
    if (i == c.size() && j == min(((int)(a).size()), ((int)(b).size()))) {
      ok = false;
      break;
    }
    if (j == min(((int)(a).size()), ((int)(b).size())) ||
        (i != ((int)(c).size()) && c[i] <= (a[j] + b[j]))) {
      ans += c[i++];
      x1++;
      x2++;
    } else {
      ans += (a[j] + b[j]);
      j++;
      x1++;
      x2++;
    }
  }
  cout << (ok ? ans : -1) << endl;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(NULL);
  cout.tie(NULL);
  int T = 1;
  while (T--) solve();
  return 0;
}
