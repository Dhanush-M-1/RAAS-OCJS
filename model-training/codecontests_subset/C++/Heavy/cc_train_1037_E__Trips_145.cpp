#include <bits/stdc++.h>
using namespace std;
int n, m, fs;
std::vector<int> yol[200005];
pair<int, int> o[200005];
int ans, yaz[200005], say[200005], del[200005];
map<pair<int, int>, int> mp;
void sil(int k) {
  if (del[k] == 1) return;
  del[k] = 1;
  ans--;
  for (int i = 0; i < yol[k].size(); ++i) {
    if (mp[make_pair(k, yol[k][i])] || mp[make_pair(yol[k][i], k)]) continue;
    say[yol[k][i]]--;
    if (say[yol[k][i]] < fs && del[yol[k][i]] == 0) sil(yol[k][i]);
  }
}
int main() {
  scanf("%d %d %d", &n, &m, &fs);
  ans = n;
  for (int i = 0; i < m; ++i) {
    scanf("%d %d", &o[i].first, &o[i].second);
    yol[o[i].first].push_back(o[i].second);
    yol[o[i].second].push_back(o[i].first);
    say[o[i].first]++;
    say[o[i].second]++;
  }
  for (int i = 1; i <= n; ++i) {
    if (say[i] < fs) {
      sil(i);
    }
  }
  for (int i = m - 1; i >= 0; --i) {
    yaz[i] = ans;
    if (del[o[i].first] == 0 && del[o[i].second] == 0) {
      say[o[i].first]--;
      say[o[i].second]--;
      mp[o[i]] = 1;
    }
    if (say[o[i].first] < fs) sil(o[i].first);
    if (say[o[i].second] < fs) sil(o[i].second);
  }
  for (int i = 0; i < m; ++i) printf("%d\n", yaz[i]);
}
