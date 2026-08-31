#include <bits/stdc++.h>
using namespace std;
const int mod = 1000000007;
const int N = 1000005;
class cmp {
 public:
  bool operator()(pair<long long, pair<long long, long long> > &A,
                  pair<long long, pair<long long, long long> > &B) {
    return A > B;
  }
};
bool by_sec(pair<long long, long long> &A, pair<long long, long long> &B) {
  return A.second < B.second;
}
bool is(pair<long long, long long> a, pair<long long, long long> b) {
  return !((a.first > b.second && a.second > b.second) ||
           (a.first < b.first && a.second < b.first));
}
long double dist(pair<long long, long long> p1, pair<long long, long long> p2) {
  return (long double)sqrt(
      (long double)(p1.first - p2.first) * (p1.first - p2.first) +
      (long double)(p1.second - p2.second) * (p1.second - p2.second));
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  string s, ans;
  long long k;
  cin >> k;
  cin >> s;
  vector<long long> v(30, 0);
  for (int i = 0; i < s.size(); i++) v[s[i] - 'a']++;
  for (char i = 'a'; i <= 'z'; i++)
    if (v[i - 'a'] % k != 0)
      return cout << -1, 0;
    else
      v[i - 'a'] /= k;
  for (char i = 'a'; i <= 'z'; i++)
    for (int j = 0; j < v[i - 'a']; j++) ans += i;
  for (int i = 0; i < s.size() / ans.size(); i++) cout << ans;
  return 0;
}
