#include <bits/stdc++.h>
using namespace std;
const char nl = '\n';
const int MAX_N = 100011;
const long long INF = (1LL << 50) + 123;
const long long MOD = 1000000007;
const long double PI = 4 * atan((long double)1);
template <typename T>
bool ckmin(T& a, const T& b) {
  return a > b ? a = b, 1 : 0;
}
template <typename T>
bool ckmax(T& a, const T& b) {
  return b > a ? a = b, 1 : 0;
}
mt19937_64 rng(chrono::steady_clock::now().time_since_epoch().count());
const int MX = 1 << 20;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n, m, k;
  cin >> n >> m >> k;
  vector<pair<int, int> > both, left, right;
  int t, a, b;
  set<pair<int, int> > rest;
  for (int i = 0; i < n; i++) {
    cin >> t >> a >> b;
    if (a && b)
      both.push_back({t, i});
    else if (a)
      left.push_back({t, i});
    else if (b)
      right.push_back({t, i});
    rest.insert({t, i});
  }
  set<pair<int, int> > rCopy = rest;
  sort(left.begin(), left.end());
  sort(right.begin(), right.end());
  sort(both.begin(), both.end());
  int sm = min((int)left.size(), (int)right.size());
  if ((int)both.size() + sm < k) {
    cout << -1 << nl;
    return 0;
  }
  long long bothSum = 0;
  int bothCount = 0;
  for (int i = 0; i < min(k, (int)both.size()); i++) {
    bothSum += both[i].first;
    bothCount++;
    rest.erase(rest.find(both[i]));
  }
  long long ans = INF;
  long long curAns = 0;
  long long rSum = 0;
  set<pair<int, int> > r;
  while ((int)r.size() < m - k) {
    if ((int)rest.size() == 0) break;
    r.insert(*rest.begin());
    rSum += rest.begin()->first;
    rest.erase(rest.begin());
  }
  int bestIdx = -1;
  if (bothCount == k && (int)r.size() == m - k)
    if (ckmin(ans, bothSum + rSum)) bestIdx = k;
  int lrCount = 0;
  for (int i = (k)-1; i >= 0; i--) {
    if (k - i - 1 >= sm || 2 * (k - i) + i > m) break;
    if (i < (int)both.size()) {
      bothSum -= both[i].first;
      rest.insert(both[i]);
      bothCount--;
    }
    curAns += left[k - i - 1].first + right[k - i - 1].first;
    lrCount += 2;
    assert(rest.find(left[k - i - 1]) != rest.end() ||
           r.find(left[k - i - 1]) != r.end());
    assert(rest.find(right[k - i - 1]) != rest.end() ||
           r.find(right[k - i - 1]) != r.end());
    if (rest.find(left[k - i - 1]) != rest.end())
      rest.erase(rest.find(left[k - i - 1]));
    if (rest.find(right[k - i - 1]) != rest.end())
      rest.erase(rest.find(right[k - i - 1]));
    if (r.find(left[k - i - 1]) != r.end())
      r.erase(r.find(left[k - i - 1])), rSum -= left[k - i - 1].first;
    if (r.find(right[k - i - 1]) != r.end())
      r.erase(r.find(right[k - i - 1])), rSum -= right[k - i - 1].first;
    while ((int)r.size() < m - 2 * (k - i) - i) {
      if ((int)rest.size() == 0) break;
      r.insert(*rest.begin());
      rSum += rest.begin()->first;
      rest.erase(rest.begin());
    }
    while ((int)r.size() > m - 2 * (k - i) - i) {
      rest.insert(*r.rbegin());
      rSum -= r.rbegin()->first;
      r.erase(--r.end());
    }
    if (bothCount == i && lrCount == 2 * (k - i) &&
        bothCount + lrCount + (int)r.size() == m) {
      if (ckmin(ans, bothSum + curAns + rSum)) bestIdx = i;
    }
  }
  if (bestIdx == -1)
    cout << -1 << nl;
  else {
    cout << ans << nl;
    for (int i = 0; i < bestIdx; i++) {
      cout << both[i].second + 1 << " ";
      rCopy.erase(rCopy.find(both[i]));
    }
    for (int i = 0; i < k - bestIdx; i++) {
      cout << left[i].second + 1 << " " << right[i].second + 1 << " ";
      rCopy.erase(rCopy.find(left[i]));
      rCopy.erase(rCopy.find(right[i]));
    }
    int count = 0;
    assert(bestIdx + 2 * (k - bestIdx) <= m);
    for (auto& a : rCopy) {
      if (count + bestIdx + 2 * (k - bestIdx) == m) break;
      count++;
      cout << a.second + 1 << " ";
    }
    cout << nl;
    assert(count + bestIdx + 2 * (k - bestIdx) == m);
  }
  return 0;
}
