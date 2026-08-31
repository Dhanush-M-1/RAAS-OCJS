#include <bits/stdc++.h>
using namespace std;
long long mod = 1000000007;
const long long num = 1000000000;
bool check1(pair<long long, long long> a, pair<long long, long long> b) {
  return a.first == b.first ? (a.second > b.second) : (a.first < b.first);
}
bool check2(pair<long long, long long> a, pair<long long, long long> b) {
  return a.second < b.second;
}
int main() {
  long long q = 1;
  while (q--) {
    long long n, m;
    cin >> n;
    vector<pair<long long, long long> > vec(n);
    for (int i = 0; i < n; i++) {
      long long a;
      cin >> a;
      vec[i].first = a;
      vec[i].second = i;
    }
    cin >> m;
    sort(vec.begin(), vec.end(), check1);
    auto v1 = vec;
    for (int i = 0; i < m; i++) {
      vec = v1;
      long long k, p;
      cin >> k >> p;
      sort(vec.begin() + n - k, vec.end(), check2);
      cout << vec[n - k + p - 1].first << endl;
      ;
    }
  }
  return 0;
}
