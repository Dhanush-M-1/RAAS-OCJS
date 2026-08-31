#include <bits/stdc++.h>
using namespace std;
const long long mx = 200009;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  ;
  long long n;
  cin >> n;
  vector<pair<long long, long long> > v;
  for (long long i = 2; i * i <= n; i++) {
    if (n % i == 0) {
      long long cnt = 0;
      while (n % i == 0) cnt++, n /= i;
      v.push_back(make_pair(cnt, i));
    }
  }
  if (n > 1) v.push_back(make_pair(1, n));
  long long sum = 0;
  for (auto x : v) sum += x.first;
  if (sum <= 1) {
    cout << 1 << '\n';
    cout << 0 << '\n';
  } else if (sum == 2)
    cout << 2 << '\n';
  else {
    cout << 1 << '\n';
    long long val = 1;
    if (v[0].first == 1) {
      val = v[0].second * v[1].second;
    } else
      val = powl(v[0].second, 2);
    cout << val << '\n';
  }
}
