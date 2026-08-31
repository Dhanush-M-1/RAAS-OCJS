#include <bits/stdc++.h>
long double pi = acos(-1.0);
const int mod = 1e9 + 7;
using namespace std;
const int N = 2e5 + 5;
vector<long long> F(N), F2(N);
long long sum(int r, vector<long long> &t) {
  long long result = 0;
  for (; r >= 0; r = (r & (r + 1)) - 1) result += t[r];
  return result;
}
void inc(int i, long long delta, vector<long long> &t) {
  for (; i < N; i = (i | (i + 1))) t[i] += delta;
}
long long sum(int l, int r, vector<long long> &t) {
  return sum(r, t) - sum(l - 1, t);
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cout.precision(20);
  cout.setf(ios::fixed);
  int n;
  cin >> n;
  vector<pair<int, int> > pts(n);
  for (int(i) = 0; (i) < n; (i)++) {
    cin >> pts[i].first;
  }
  vector<int> vv;
  for (int(i) = 0; (i) < n; (i)++) {
    cin >> pts[i].second;
    vv.push_back(pts[i].second);
  }
  sort((vv).begin(), (vv).end());
  vv.resize(unique((vv).begin(), (vv).end()) - vv.begin());
  for (int(i) = 0; (i) < n; (i)++) {
    pts[i].second =
        lower_bound((vv).begin(), (vv).end(), pts[i].second) - vv.begin();
  }
  sort((pts).begin(), (pts).end());
  for (int(i) = 0; (i) < n; (i)++) {
    inc(pts[i].second, pts[i].first, F);
    inc(pts[i].second, 1, F2);
  }
  long long ans = 0;
  for (int(i) = 0; (i) < n; (i)++) {
    int v = pts[i].second;
    inc(v, -pts[i].first, F);
    inc(v, -1, F2);
    long long sum1 = sum(v, N - 1, F);
    long long cnt = sum(v, N - 1, F2);
    ans += sum1 - cnt * (long long)pts[i].first;
  }
  cout << ans;
  return 0;
}
