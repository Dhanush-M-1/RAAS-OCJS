#include <bits/stdc++.h>
using namespace std;
inline int read() {
  int x = 0;
  char ch;
  while (!isdigit(ch = getchar()))
    ;
  x = ch - 48;
  while (isdigit(ch = getchar())) x = x * 10 + ch - 48;
  return x;
}
const int MAXN = 2e5 + 5;
int n, m, k;
vector<pair<int, int> > t[4], tmp;
vector<int> ans;
inline int calc(int x) {
  int ned = max(0, k - x), tot = 0;
  if (ned > min(t[1].size(), t[2].size())) return 1e9;
  for (int i = 0; i < x; i++) tot += t[3][i].first;
  for (int i = 0; i < ned; i++) tot += t[1][i].first + t[2][i].first;
  tmp.clear();
  for (auto p : t[0]) tmp.push_back(p);
  for (int i = x; i < t[3].size(); i++) tmp.push_back(t[3][i]);
  for (int i = ned; i < t[2].size(); i++) tmp.push_back(t[2][i]);
  for (int i = ned; i < t[1].size(); i++) tmp.push_back(t[1][i]);
  sort(tmp.begin(), tmp.end());
  for (int i = 0; i < m - x - 2 * ned; i++) tot += tmp[i].first;
  return tot;
}
int main() {
  n = read(), m = read(), k = read();
  int tp1 = 0, tp2 = 0, tp3 = 0;
  for (int i = 1, x, a, b; i <= n; i++)
    x = read(), a = read(), b = read(), t[2 * a + b].push_back(make_pair(x, i)),
    tp1 += a, tp2 += b, tp3 += a & b;
  if (tp1 < k || tp2 < k || 2 * k - tp3 > m) {
    puts("-1");
    return 0;
  }
  for (int i = 0; i <= 3; i++) sort(t[i].begin(), t[i].end());
  int l = max(0, 2 * k - m), r = t[3].size();
  while (l < r) {
    int mid1 = (2 * l + r) / 3, mid2 = (2 * r + l + 2) / 3;
    if (calc(mid1) < calc(mid2))
      r = mid2 - 1;
    else
      l = mid1 + 1;
  }
  int ned = max(0, k - l), tot = 0;
  for (int i = 0; i < l; i++)
    tot += t[3][i].first, ans.push_back(t[3][i].second);
  for (int i = 0; i < ned; i++)
    tot += t[1][i].first + t[2][i].first, ans.push_back(t[1][i].second),
        ans.push_back(t[2][i].second);
  tmp.clear();
  for (auto p : t[0]) tmp.push_back(p);
  for (int i = l; i < t[3].size(); i++) tmp.push_back(t[3][i]);
  for (int i = ned; i < t[2].size(); i++) tmp.push_back(t[2][i]);
  for (int i = ned; i < t[1].size(); i++) tmp.push_back(t[1][i]);
  sort(tmp.begin(), tmp.end());
  for (int i = 0; i < m - l - 2 * ned; i++)
    tot += tmp[i].first, ans.push_back(tmp[i].second);
  printf("%d\n", tot);
  for (int x : ans) printf("%d ", x);
  return 0;
}
