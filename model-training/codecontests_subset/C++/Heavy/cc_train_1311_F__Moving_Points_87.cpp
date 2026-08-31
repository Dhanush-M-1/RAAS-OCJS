#include <bits/stdc++.h>
using namespace std;
const long long N = 2e5 + 500;
long long n, t1[N], t2[N];
void upd1(long long val, long long pos) {
  while (pos < n) {
    t1[pos] += val;
    pos = (pos | (pos + 1));
  }
}
void upd2(long long val, long long pos) {
  while (pos < n) {
    t2[pos] += val;
    pos = (pos | (pos + 1));
  }
}
long long get1(long long pos) {
  long long res = 0;
  while (pos >= 0) {
    res += t1[pos];
    pos = (pos & (pos + 1)) - 1;
  }
  return res;
}
long long get2(long long pos) {
  long long res = 0;
  while (pos >= 0) {
    res += t2[pos];
    pos = (pos & (pos + 1)) - 1;
  }
  return res;
}
int main() {
  cin >> n;
  vector<pair<long long, long long> > a(n);
  vector<long long> comp;
  map<long long, long long> new_val;
  for (int i = 0; i < n; i++) {
    cin >> a[i].first;
  }
  for (int i = 0; i < n; i++) {
    cin >> a[i].second;
    comp.push_back(a[i].second);
  }
  sort(a.begin(), a.end());
  sort(comp.begin(), comp.end());
  long long k = 0;
  new_val[comp[0]] = k;
  for (int i = 1; i < comp.size(); i++) {
    if (comp[i] != comp[i - 1]) k++;
    new_val[comp[i]] = k;
  }
  for (int i = 0; i < n; i++) {
    a[i].second = new_val[a[i].second];
  }
  long long ans = 0;
  for (int i = 0; i < n; i++) {
    long long pos = a[i].second;
    long long cnt = get1(pos);
    long long sum = get2(pos);
    ans += ((cnt * a[i].first) - sum);
    upd1(1, pos);
    upd2(a[i].first, pos);
  }
  cout << ans << endl;
}
