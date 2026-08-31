#include <bits/stdc++.h>
using namespace std;
long long int max(long long int a, long long int b) {
  if (a > b)
    return a;
  else
    return b;
}
long long int min(long long int a, long long int b) {
  if (a < b)
    return a;
  else
    return b;
}
const int dx[4] = {-1, 1, 0, 0};
const int dy[4] = {0, 0, -1, 1};
int XX[] = {-1, -1, -1, 0, 0, 1, 1, 1};
int YY[] = {-1, 0, 1, -1, 1, -1, 0, 1};
vector<vector<pair<long long int, long long int> > > vec;
long long int c, d;
long long int dp[500005][12];
long long int func(long long int ind, long long int c2) {
  if (ind >= vec.size()) return 0;
  if (dp[ind][c2] != -1) return dp[ind][c2];
  long long int count = -9000000000000000000;
  count = max(count, func(ind + 1, c2));
  long long int maxi = -9000000000000000000;
  for (int k = 0; k < vec[ind].size(); k++) {
    if (vec[ind][k].first == 1) maxi = max(maxi, vec[ind][k].second);
  }
  if (maxi != -9000000000000000000) {
    if (c2 == 9) {
      count = max(count, maxi * 2 + func(ind + 1, 0));
    } else
      count = max(count, maxi + func(ind + 1, c2 + 1));
  }
  long long int maxi1 = -9000000000000000000, maxi2 = -9000000000000000000;
  long long int maxi3 = -9000000000000000000, maxi7 = -9000000000000000000;
  vector<long long int> vec7;
  for (int k = 0; k < vec[ind].size(); k++) {
    if (vec[ind][k].first == 1) {
      vec7.push_back(vec[ind][k].second);
      if (vec[ind][k].second > maxi1) {
        maxi2 = maxi1;
        maxi1 = vec[ind][k].second;
      } else if (vec[ind][k].second > maxi2) {
        maxi2 = vec[ind][k].second;
      }
    }
    if (vec[ind][k].first == 2) {
      maxi3 = max(maxi3, vec[ind][k].second);
    }
    if (vec[ind][k].first == 3) maxi7 = max(maxi7, vec[ind][k].second);
  }
  if (vec7.size() >= 3) {
    sort(vec7.begin(), vec7.end());
    reverse(vec7.begin(), vec7.end());
    if (c2 == 7) {
      count = max(count, vec7[0] * 2 + vec7[1] + vec7[2] + func(ind + 1, 0));
    } else if (c2 == 8) {
      count = max(count, vec7[0] * 2 + vec7[1] + vec7[2] + func(ind + 1, 1));
    } else if (c2 == 9)
      count = max(count, vec7[0] * 2 + vec7[1] + vec7[2] + func(ind + 1, 2));
    else
      count = max(count, vec7[0] + vec7[1] + vec7[2] + func(ind + 1, c2 + 3));
  }
  if (maxi7 != -9000000000000000000) {
    if (c2 == 9) {
      count = max(count, maxi7 * 2 + func(ind + 1, 0));
    } else
      count = max(count, maxi7 + func(ind + 1, c2 + 1));
  }
  if (maxi1 != -9000000000000000000 && maxi2 != -9000000000000000000) {
    if (c2 == 8) {
      count = max(count, maxi1 * 2 + maxi2 + func(ind + 1, 0));
    } else if (c2 == 9) {
      count = max(count, maxi1 * 2 + maxi2 + func(ind + 1, 1));
    } else {
      count = max(count, maxi1 + maxi2 + func(ind + 1, c2 + 2));
    }
  }
  if (maxi3 != -9000000000000000000) {
    if (c2 == 9) {
      count = max(count, maxi3 * 2 + func(ind + 1, 0));
    } else
      count = max(count, maxi3 + func(ind + 1, c2 + 1));
  }
  if (maxi != -9000000000000000000 && maxi3 != -9000000000000000000) {
    long long int maxi5 = max(maxi, maxi3), maxi6 = min(maxi, maxi3);
    if (c2 == 8) {
      count = max(count, maxi5 * 2 + maxi6 + func(ind + 1, 0));
    } else if (c2 == 9) {
      count = max(count, maxi5 * 2 + maxi6 + func(ind + 1, 1));
    } else
      count = max(count, maxi5 + maxi6 + func(ind + 1, c2 + 2));
  }
  return dp[ind][c2] = count;
}
int main() {
  memset(dp, -1, sizeof(dp));
  ios_base::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL);
  long long int t, n, i, j, k;
  cin >> n;
  for (i = 0; i < n; i++) {
    vector<pair<long long int, long long int> > vec2;
    cin >> k;
    for (j = 0; j < k; j++) {
      cin >> c >> d;
      vec2.push_back(make_pair(c, d));
    }
    vec.push_back(vec2);
  }
  long long int ans = func(0, 0);
  cout << ans;
}
