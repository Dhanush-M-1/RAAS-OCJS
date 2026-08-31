#include <bits/stdc++.h>
using namespace std;
double const EPS = 1e-8, PI = acos(-1);
const int N = 2e5 + 9, M = 30 + 7, OO = (int)1e6 + 1, MAXN = 4 * N;
const long long MOD = 1e9 + 7, INF = 1e18 + 9;
void INPUT() {}
bool cmp(pair<int, pair<bool, bool>> a, pair<int, pair<bool, bool>> b) {
  if (a.first == b.first) {
    return (b.second.first && b.second.second);
  }
  return a.first < b.first;
}
int main() {
  ios::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);
  cout << fixed << setprecision(0);
  INPUT();
  int n, k;
  cin >> n >> k;
  vector<pair<int, pair<bool, bool>>> v(n), fir, sec, bot;
  for (int i = 0; i < n; i++) {
    cin >> v[i].first >> v[i].second.first >> v[i].second.second;
    if (v[i].second.first && v[i].second.second)
      bot.push_back(v[i]);
    else if (v[i].second.first)
      fir.push_back(v[i]);
    else if (v[i].second.second)
      sec.push_back(v[i]);
  }
  sort(bot.begin(), bot.end());
  sort(fir.begin(), fir.end());
  sort(sec.begin(), sec.end());
  vector<long long> botCum(((int)((bot).size())) + 1, 0),
      firCum(((int)((fir).size())) + 1, 0),
      secCum(((int)((sec).size())) + 1, 0);
  for (int i = 1; i <= ((int)((bot).size())); i++) {
    botCum[i] = bot[i - 1].first + botCum[i - 1];
  }
  for (int i = 1; i <= ((int)((fir).size())); i++) {
    firCum[i] = fir[i - 1].first + firCum[i - 1];
  }
  for (int i = 1; i <= ((int)((sec).size())); i++) {
    secCum[i] = sec[i - 1].first + secCum[i - 1];
  }
  long long ans = INF;
  for (int i = 0; i <= k; i++) {
    int need = k - i;
    if (((int)((bot).size())) < i || ((int)((fir).size())) < need ||
        ((int)((sec).size())) < need)
      continue;
    ans = min(ans, botCum[i] + firCum[need] + secCum[need]);
  }
  cout << (ans == INF ? -1 : ans);
  return 0;
}
