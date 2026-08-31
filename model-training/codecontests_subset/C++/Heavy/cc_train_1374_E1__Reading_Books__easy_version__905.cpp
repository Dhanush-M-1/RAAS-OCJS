#include <bits/stdc++.h>
using namespace std;
const long long INF = 1e9;
const long long INFF = 1e18;
const long long MAXN = 510;
const long long MOD = 1e9 + 7;
const double PI = acos(-1.0);
const double INFD = 1E9;
const double EPS = 1e-9;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long n, k;
  cin >> n >> k;
  deque<long long> onlyA, onlyB, both;
  for (long long i = 1; i <= n; i++) {
    long long val, a, b;
    cin >> val >> a >> b;
    if (a && b)
      both.push_back(val);
    else if (a)
      onlyA.push_back(val);
    else if (b)
      onlyB.push_back(val);
  }
  sort(onlyA.begin(), onlyA.end());
  sort(onlyB.begin(), onlyB.end());
  sort(both.begin(), both.end());
  long long takeA = onlyA.size();
  long long takeB = onlyB.size();
  long long harus = 0;
  long long ans = 0;
  while (takeA < k && !both.empty()) {
    long long cur = both.front();
    both.pop_front();
    ++takeA;
    ++takeB;
    ++harus;
    ans += cur;
  }
  while (takeB < k && !both.empty()) {
    long long cur = both.front();
    both.pop_front();
    ++takeA;
    ++takeB;
    ++harus;
    ans += cur;
  }
  if (takeA < k || takeB < k)
    cout << -1 << endl;
  else {
    while (onlyA.size() > max(0ll, k - harus)) onlyA.pop_back();
    while (onlyB.size() > max(0ll, k - harus)) onlyB.pop_back();
    for (auto it : onlyA) {
      ans += it;
    }
    for (auto it : onlyB) {
      ans += it;
    }
    for (auto it : both) {
      if (onlyA.empty() || onlyB.empty()) break;
      if (onlyA.back() + onlyB.back() > it) {
        ans += it - (onlyA.back() + onlyB.back());
        onlyA.pop_back();
        onlyB.pop_back();
      }
    }
    cout << ans << endl;
  }
  return 0;
}
