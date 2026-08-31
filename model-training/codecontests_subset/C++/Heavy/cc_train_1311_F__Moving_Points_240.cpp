#include <bits/stdc++.h>
using namespace std;
void transform(long long int a[], long long int n) {
  map<long long int, vector<long long int> > m;
  for (long long int i = 0; i < (n); i++) m[a[i]].push_back(i);
  long long int rank = 1;
  for (auto c : m) {
    for (auto i : c.second) a[i] = rank;
    rank++;
  }
}
const long long int N = 2e5 + 5;
long long int n = -1e9;
void update(long long int B[], long long int x, long long int val) {
  for (; x <= n; x += x & -x) B[x] += val;
}
long long int query(long long int B[], long long int x) {
  long long int sum = 0;
  for (; x > 0; x -= x & -x) sum += B[x];
  return sum;
}
int main() {
  long long int num;
  cin >> num;
  long long int x[num + 5], v[num + 5], ans = 0;
  vector<pair<long long int, long long int> > pts;
  for (long long int i = 0; i < (num); i++) cin >> x[i];
  for (long long int i = 0; i < (num); i++) cin >> v[i];
  for (long long int i = 0; i < (num); i++)
    pts.push_back(make_pair(x[i], v[i]));
  sort((pts).begin(), (pts).end());
  for (long long int i = 0; i < (num); i++)
    x[i] = pts[i].first, v[i] = pts[i].second;
  transform(v, num);
  n = *max_element(v, v + num);
  long long int pref[N] = {0}, freq[N] = {0};
  update(pref, v[num - 1], x[num - 1]);
  update(freq, v[num - 1], 1);
  for (long long int i = num - 2; i > (-1); i--) {
    long long int sum = query(pref, n) - query(pref, v[i] - 1);
    long long int nump = query(freq, n) - query(freq, v[i] - 1);
    ans += (sum - nump * x[i]);
    update(pref, v[i], x[i]);
    update(freq, v[i], 1);
  }
  cout << ans << endl;
}
