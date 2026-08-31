#include <bits/stdc++.h>
using namespace std;
long long n, k, c, d, ans;
vector<pair<long long, long long> > tmp, cards[200002];
long long dp[200002][11];
bool cmp(pair<long long, long long> a, pair<long long, long long> b) {
  if (a.first < b.first)
    return true;
  else if (a.first > b.first)
    return false;
  else
    return a.second > b.second;
}
void deb() {
  for (int i = 0; i < n; i++) {
    long long sez = cards[i].size();
    cout << i << ": \n";
    for (int j = 0; j < sez; j++) {
      cout << cards[i][j].first << " " << cards[i][j].second << "\n";
    }
  }
}
void deb2() {
  for (int i = 1; i <= n; i++) {
    long long res = 0;
    for (int j = 0; j < 10; j++) res = max(res, dp[i][j]);
    cout << i << "-->" << res << "\n";
  }
}
int main() {
  ans = 0;
  cin >> n;
  for (int i = 0; i <= n; i++) {
    for (int j = 0; j < 11; j++) {
      dp[i][j] = -1;
    }
  }
  dp[0][0] = 0;
  for (int i = 0; i < n; i++) {
    long long cnt[4];
    for (int j = 0; j < 4; j++) cnt[j] = 0;
    cin >> k;
    for (int j = 0; j < k; j++) {
      cin >> c >> d;
      tmp.push_back(make_pair(c, d));
    }
    sort(tmp.begin(), tmp.end(), cmp);
    for (int j = 0; j < k; j++) {
      if (tmp[j].first == 1) {
        if (cnt[1] < 3) {
          cards[i].push_back(tmp[j]);
          cnt[1]++;
        }
      } else {
        if (cnt[tmp[j].first] < 1) {
          cards[i].push_back(tmp[j]);
          cnt[tmp[j].first]++;
        }
      }
    }
    tmp.clear();
  }
  for (int i = 0; i < n; i++) {
    vector<pair<pair<long long, long long>, long long> > tmp2;
    long long sez = cards[i].size();
    for (int j = 0; j < (1 << sez); j++) {
      long long cost = 0, cnt = 0, cnt2 = 0, maks = 0;
      for (int k = 0; k < sez; k++) {
        if (j & (1 << k)) {
          cost += cards[i][k].second;
          cnt += cards[i][k].first;
          maks = max(maks, cards[i][k].second);
          cnt2++;
        }
      }
      if (cnt > 3) continue;
      tmp2.push_back(make_pair(make_pair(cost, cnt2), maks));
    }
    long long sez2 = tmp2.size();
    for (int j = 0; j < 10; j++) {
      if (dp[i][j] == -1) continue;
      for (int k = 0; k < sez2; k++) {
        dp[i + 1][(j + tmp2[k].first.second) % 10] =
            max(dp[i + 1][(j + tmp2[k].first.second) % 10],
                dp[i][j] + tmp2[k].first.first +
                    (j + tmp2[k].first.second >= 10 ? tmp2[k].second : 0));
      }
    }
    tmp2.clear();
  }
  for (int i = 0; i < 10; i++) {
    ans = max(ans, dp[n][i]);
  }
  cout << ans << "\n";
}
