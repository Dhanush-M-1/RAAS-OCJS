#include <bits/stdc++.h>
using namespace std;
bool cmp(pair<long long, long long> p1, pair<long long, long long> p2) {
  return (p1.second > p2.second);
}
long long solve(vector<vector<long long> >& dp,
                vector<pair<long long, long long> >& v, long long idx,
                long long cap, long long k, long long n) {
  if (k == 0 && cap == 0) return 0;
  if (k == 0 || cap == 0) return -1e11;
  if (dp[k][cap] != -1e7) return dp[k][cap];
  if (v[idx].second <= cap) {
    dp[k][cap] =
        max(solve(dp, v, idx + 1, cap - v[idx].second, k - 1, n) + v[idx].first,
            dp[k][cap]);
    return dp[k][cap];
  } else {
    return solve(dp, v, idx + 1, cap, k, n);
  }
  return 0;
}
void print(vector<vector<long long> >& tp,
           vector<pair<long long, long long> >& v, long long taken,
           long long cap, long long n, long long ans) {
  vector<long long> mark(n);
  while (cap > 0) {
    for (long long i = 0; i < n; i++) {
      if (mark[i] == 0 && cap >= v[i].second &&
          tp[taken - 1][cap - v[i].second] == (ans - v[i].first)) {
        cout << i << " ";
        mark[i] = 1;
        cap -= v[i].second;
        taken--;
        ans -= v[i].first;
      }
    }
  }
  cout << endl;
  return;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long n;
  cin >> n;
  vector<pair<long long, long long> > v(n);
  long long tw = 0, ts = 0;
  for (long long i = 0; i < n; i++) {
    cin >> v[i].first;
    tw += v[i].first;
  }
  for (long long i = 0; i < n; i++) {
    cin >> v[i].second;
    ts += v[i].second;
  }
  sort(v.begin(), v.end(), cmp);
  long long tmp = 0, k = 0;
  for (long long i = 0; i < n; i++) {
    tmp += v[i].second;
    if (tmp >= tw) {
      k = i + 1;
      break;
    }
  }
  vector<vector<long long> > tp(k + 1, vector<long long>(10005, -1));
  tp[0][0] = 0;
  for (long long i = 0; i < n; i++) {
    vector<vector<long long> > dp = tp;
    for (long long taken = 1; taken <= k; taken++) {
      for (long long cap = v[i].second; cap <= 10000; cap++) {
        if (tp[taken - 1][cap - v[i].second] >= 0) {
          dp[taken][cap] = max(tp[taken - 1][cap - v[i].second] + v[i].first,
                               tp[taken][cap]);
        }
      }
    }
    tp = dp;
  }
  long long ans = 0, idx = 0;
  for (long long i = tw; i <= 10000; i++) {
    ans = max(ans, tp[k][i]);
  }
  cout << k << " " << (tw - ans);
  return 0;
}
