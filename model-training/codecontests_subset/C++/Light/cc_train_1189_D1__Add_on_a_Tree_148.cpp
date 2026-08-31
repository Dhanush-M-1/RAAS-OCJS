#include <bits/stdc++.h>
using namespace std;
const long long N = 1e5 + 7;
long long n;
vector<long long> add[N];
void nie() {
  cout << "NO";
  exit(0);
}
void yie() {
  cout << "YES";
  exit(0);
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  vector<pair<long long, long long>> v;
  cin >> n;
  for (long long i = 1; i < n; i++) {
    long long x, y;
    cin >> x >> y;
    add[x].push_back(y);
    add[y].push_back(x);
    v.push_back({x, y});
  }
  if (n == 2) yie();
  if (n == 3) nie();
  for (auto i : v) {
    if (add[i.second].size() == 2 || add[i.first].size() == 2) nie();
  }
  yie();
  return 0;
}
