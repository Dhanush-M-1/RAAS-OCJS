#include <bits/stdc++.h>
using namespace std;
const int mod = 1e9 + 7;
pair<pair<int, int>, pair<int, int> > s[1 << 20];
int f[1 << 11];
int get(int k) { return k == f[k] ? k : f[k] = get(f[k]); }
int main(void) {
  srand(time(0));
  cout << fixed << setprecision(7);
  cerr << fixed << setprecision(7);
  int n, m, q;
  ios_base ::sync_with_stdio(0);
  scanf("%d", &n);
  scanf("%d", &m);
  scanf("%d", &q);
  for (int i = 1; i <= m; ++i) {
    scanf("%d", &s[i].second.first);
    scanf("%d", &s[i].second.second);
    scanf("%d", &s[i].first.first);
    s[i].first.second = i;
  }
  sort(s + 1, s + 1 + m);
  reverse(s + 1, s + 1 + m);
  for (int qwerty = 1; qwerty <= q; ++qwerty) {
    int l, r;
    scanf("%d", &l);
    scanf("%d", &r);
    for (int i = 1; i <= n + n + 1; ++i) f[i] = i;
    int ans = -1;
    for (int i = 1; i <= m && ans == -1; ++i)
      if (l <= s[i].first.second && s[i].first.second <= r)
        if (get(s[i].second.first << 1) == get(s[i].second.second << 1))
          ans = s[i].first.first;
        else {
          f[get(s[i].second.first << 1)] = get(s[i].second.second << 1 | 1);
          f[get(s[i].second.first << 1 | 1)] = get(s[i].second.second << 1);
        }
    cout << ans << '\n';
  }
  return 0;
}
