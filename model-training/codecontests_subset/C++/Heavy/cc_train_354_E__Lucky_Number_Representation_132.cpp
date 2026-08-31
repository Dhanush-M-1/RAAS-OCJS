#include <bits/stdc++.h>
using namespace std;
void solve();
void precalc();
int main() {
  int t = 1;
  precalc();
  cin >> t;
  while (t--) solve();
  return 0;
}
vector<long long> composition[60];
void precalc() {
  for (long long i = 0; i <= 6; ++i)
    for (long long j = 0; i + j <= 6; ++j) {
      long long k = 6 - i - j;
      composition[j * 4 + k * 7].push_back(i);
      composition[j * 4 + k * 7].push_back(j);
      composition[j * 4 + k * 7].push_back(k);
    }
}
pair<long long, long long> pred[20][6];
void solve() {
  long long n;
  cin >> n;
  vector<long long> now;
  long long k = n;
  for (long long i = 0; i < 19; ++i) {
    now.push_back(k % 10);
    k /= 10;
  }
  for (long long i = 0; i < 20; ++i)
    for (long long j = 0; j < 6; ++j) pred[i][j] = make_pair(-1, -1);
  for (long long i = 0; i < 60; ++i)
    if (composition[i].size() == 3 && (i % 10) == now[0]) {
      pred[0][i / 10] = make_pair(0, i);
    }
  for (long long i = 0; i < 18; ++i)
    for (long long carry = 0; carry < 6; ++carry) {
      if (pred[i][carry].first == -1) continue;
      for (long long nex = 0; nex < 60; ++nex)
        if (composition[nex].size() == 3) {
          long long nexSum = nex + carry;
          if (nexSum % 10 != now[i + 1]) continue;
          pred[i + 1][nexSum / 10] = make_pair(carry, nex);
        }
    }
  if (pred[18][0].first == -1) {
    cout << "-1\n";
    return;
  }
  vector<long long> res[6];
  long long cur = 18;
  long long sum = pred[18][0].second;
  long long carry = 0;
  do {
    for (long long i = 0; i < composition[sum][0]; ++i) res[i].push_back(0);
    for (long long i = composition[sum][0];
         i < composition[sum][0] + composition[sum][1]; ++i)
      res[i].push_back(4);
    for (long long i = composition[sum][0] + composition[sum][1]; i < 6; ++i)
      res[i].push_back(7);
    sum = pred[cur][carry].second;
    carry = pred[cur][carry].first;
    --cur;
  } while (cur >= 0);
  for (long long i = 0; i < composition[sum][0]; ++i) res[i].push_back(0);
  for (long long i = composition[sum][0];
       i < composition[sum][0] + composition[sum][1]; ++i)
    res[i].push_back(4);
  for (long long i = composition[sum][0] + composition[sum][1]; i < 6; ++i)
    res[i].push_back(7);
  for (long long i = 0; i < 6; ++i) {
    long long cur = 0;
    for (long long j = 0; j < res[i].size(); ++j) cur = cur * 10 + res[i][j];
    cout << cur << ' ';
  }
  cout << "\n";
}
