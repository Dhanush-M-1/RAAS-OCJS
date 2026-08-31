#include <bits/stdc++.h>
using namespace std;
const int maxint = numeric_limits<int>::max();
const long long maxll = numeric_limits<long long>::max();
const int arr = 2e5 + 10;
const int ar = 2e3 + 10;
const long double pi = acos(-1);
const long long md = 1e9 + 7;
const long double eps = 1e-6;
int cnt[ar];
int main() {
  int k;
  string s;
  cin >> k >> s;
  if (s.length() % k != 0) return cout << -1, 0;
  for (auto i : s) cnt[i]++;
  string res = "";
  for (char i = 'a'; i <= 'z'; i++) {
    if (cnt[i] % k != 0) return cout << -1, 0;
    for (int j = 0; j < cnt[i] / k; j++) res += i;
  }
  string ans = "";
  for (int i = 0; i < k; i++) ans += res;
  cout << ans;
}
