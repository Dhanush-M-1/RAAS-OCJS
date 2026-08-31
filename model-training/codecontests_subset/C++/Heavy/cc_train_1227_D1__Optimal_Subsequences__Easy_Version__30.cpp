#include <bits/stdc++.h>
using namespace std;
long long n, m, k;
pair<long long, long long> arr[200000];
bool cmp(pair<long long, long long> a, pair<long long, long long> b) {
  if (a.first == b.first) return a.second < b.second;
  return a.first > b.first;
}
signed main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  cin >> n;
  for (long long i = (0); i < (n); i++) {
    long long x;
    cin >> x;
    arr[i] = {x, i};
  }
  sort(arr, arr + n, cmp);
  long long TEST_CASE;
  cin >> TEST_CASE;
  for (long long TEST_NUM = 1; TEST_NUM <= TEST_CASE; TEST_NUM++) {
    long long k, p;
    cin >> k >> p;
    priority_queue<pair<long long, long long>,
                   vector<pair<long long, long long>>,
                   greater<pair<long long, long long>>>
        pq;
    for (long long i = (0); i < (k); i++)
      pq.push({arr[i].second, arr[i].first});
    for (long long i = (0); i < (p - 1); i++) pq.pop();
    cout << pq.top().second << '\n';
  }
}
