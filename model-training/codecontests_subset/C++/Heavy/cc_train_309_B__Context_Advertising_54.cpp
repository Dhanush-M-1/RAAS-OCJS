#include <bits/stdc++.h>
using namespace std;
const int MAX = 1000000 + 10;
const int NUM = 20;
int n, r, c;
string s[MAX];
int sum[MAX];
int fa[MAX][NUM];
int getlen(int l, int r) { return sum[r] - sum[l - 1] + (r - (l - 1) - 1); }
int main() {
  int i, j;
  scanf("%d%d%d", &n, &r, &c);
  for ((i) = (1); (i) <= (n); ++(i)) cin >> s[i];
  for ((i) = (1); (i) <= (n); ++(i)) sum[i] = sum[i - 1] + s[i].size();
  int ll = 1;
  pair<int, int> ans;
  for ((i) = (1); (i) <= (n); ++(i)) {
    while (ll <= i && getlen(ll, i) > c) ++ll;
    fa[i][0] = ll - 1;
    for ((j) = (1); (j) != (NUM); ++(j)) fa[i][j] = fa[fa[i][j - 1]][j - 1];
    int j = NUM - 1, u = i, s = r;
    while (s) {
      while (j && (1 << j) > s) --j;
      u = fa[u][j];
      s -= (1 << j);
    }
    pair<int, int> t = make_pair(u, i);
    if (t.second - t.first > ans.second - ans.first || !ans.second) ans = t;
  }
  int now = ans.first + 1;
  int last = c + 1;
  int sum = 0;
  for (; now <= ans.second; ++now) {
    if (last + 1 + (int)s[now].size() > c) {
      ++sum;
      if (now != ans.first + 1) cout << endl;
      last = s[now].size();
    } else {
      last += 1 + s[now].size();
      cout << " ";
    }
    cout << s[now];
  }
  for (; sum < r; ++sum) cout << endl;
  return 0;
}
