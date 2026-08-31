#include <bits/stdc++.h>
using namespace std;
const long long N = 1e9 + 5;
bool col2(pair<long long, long long> p1, pair<long long, long long> p2) {
  if (p1.first == p2.first)
    return p2.second < p1.second;
  else
    return p1.first < p2.first;
}
struct comp {
  bool operator()(long long const &x, long long const &y) { return x > y; }
};
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  ;
  long long n, k;
  cin >> n >> k;
  vector<long long> a;
  vector<long long> b;
  vector<long long> both;
  for (long long i = 0; i < n; i++) {
    long long x, y, z;
    cin >> x >> y >> z;
    if (y == 1 && z == 1)
      both.push_back(x);
    else if (y == 1 && z != 1)
      a.push_back(x);
    else if (y != 1 && z == 1)
      b.push_back(x);
  }
  sort(a.begin(), a.end());
  sort(b.begin(), b.end());
  for (long long i = 0; i < min((long long)a.size(), (long long)b.size()); i++)
    both.push_back(a[i] + b[i]);
  sort(both.begin(), both.end());
  long long ans1 = 0;
  for (long long i = 0; i < (long long)both.size(); i++) {
    if (k <= 0) break;
    ans1 += both[i];
    k--;
  }
  if (k > 0)
    cout << -1 << endl;
  else
    cout << ans1 << endl;
}
