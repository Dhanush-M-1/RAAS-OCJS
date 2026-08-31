#include <bits/stdc++.h>
using namespace std;
int n, r, c;
int a[1000010], ans[1000010], nxt[1000010];
string s;
void work(int x) {
  if (x == 1) {
    for (int i = 1; i <= n; ++i) ans[i] = nxt[i];
    return;
  }
  work(x / 2);
  for (int i = 1; i <= n; ++i) {
    ans[i] = ans[ans[i]];
    if (x & 1) ans[i] = nxt[ans[i]];
  }
}
int main() {
  ios::sync_with_stdio(false);
  cin >> n >> r >> c;
  a[1] = 0;
  for (int i = 1; i <= n; ++i) {
    string ss;
    cin >> ss;
    s += ss;
    a[i + 1] = a[i] + ss.length() + 1;
    s += ' ';
  }
  for (int i = n + 1, j = n + 1; i >= 0; --i) {
    while (a[j] - a[i] - 1 > c) --j;
    ans[i] = i;
    nxt[i] = j;
  }
  work(r);
  int p = 1;
  for (int i = 2; i <= n; ++i)
    if (ans[i] - i > ans[p] - p) p = i;
  for (int i = 1; i <= r; ++i) {
    for (int j = a[p]; j <= a[nxt[p]] - 2; ++j) cout << s[j];
    p = nxt[p];
    cout << endl;
  }
  return 0;
}
