#include <bits/stdc++.h>
using namespace std;
const long long mx = 2 * 1e5 + 5;
const long long mod = 1e9 + 7;
long long sum[mx];
long long num[mx];
void update(int pos, int value) {
  while (pos <= mx) {
    sum[pos] += value;
    num[pos]++;
    pos += (pos & -pos);
  }
}
pair<int, long long> query(int pos) {
  long long summ = 0;
  long long numm = 0;
  while (pos >= 1) {
    summ += sum[pos];
    numm += num[pos];
    pos -= (pos & -pos);
  }
  return {numm, summ};
}
int main() {
  int n;
  cin >> n;
  pair<long long, long long> p[n];
  map<long long, int> mp;
  for (int i = 0; i < n; i++) {
    cin >> p[i].first;
  }
  for (int i = 0; i < n; i++) {
    cin >> p[i].second;
    mp[p[i].second] = i;
  }
  int cur = 1LL;
  for (auto& i : mp) {
    i.second = cur;
    cur++;
  }
  for (int i = 0; i < n; i++) {
    p[i].second = mp[p[i].second];
  }
  sort(p, p + n);
  long long ans = 0;
  for (int i = 0; i < n; i++) {
    long long myv = p[i].second;
    long long myx = p[i].first;
    pair<long long, long long> cnt = query(myv);
    ans += (1LL * myx * cnt.first);
    ans -= cnt.second;
    update(myv, myx);
  }
  cout << ans;
}
