#include <bits/stdc++.h>
using namespace std;
const int inf = 1 << 30;
const long long mod = 1e9 + 7;
const long long linf = 1LL << 62;
const double EPS = 1e-7;
template <class T>
void chmin(T& x, T y) {
  if (x > y) x = y;
}
template <class T>
void chmax(T& x, T y) {
  if (x < y) x = y;
}
int n, k;
priority_queue<long long, vector<long long>, greater<long long>> pq[3];
int main() {
  cin >> n >> k;
  for (int i = 0; i < n; i++) {
    int t, a, b;
    cin >> t >> a >> b;
    if (a == 1 && b == 1) {
      pq[0].push(t);
    } else if (a == 1) {
      pq[1].push(t);
    } else if (b == 1) {
      pq[2].push(t);
    }
  }
  if (pq[0].size() + min(pq[1].size(), pq[2].size()) < k) {
    cout << -1 << endl;
    return 0;
  }
  for (int i = 0; i < 3; i++) pq[i].push(inf);
  long long ans = 0;
  while (k--) {
    long long t1 = pq[0].top(), t2 = pq[1].top() + pq[2].top();
    if (t1 < t2) {
      ans += t1;
      pq[0].pop();
    } else {
      ans += t2;
      pq[1].pop();
      pq[2].pop();
    }
  }
  cout << ans << endl;
}
