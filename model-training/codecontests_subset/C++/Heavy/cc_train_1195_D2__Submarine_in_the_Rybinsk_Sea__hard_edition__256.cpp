#include <bits/stdc++.h>
using namespace std;
const long long MOD = 998244353;
const long long MOD20 = 172998509;
const long long MOD19 = 716070898;
long long left(const string& s, int cnt) {
  if (s.size() == 10 && cnt == 9) return MOD19;
  if (s.size() == 10 && cnt == 10) return MOD20;
  int sz = s.size();
  int csz = sz;
  string res = "";
  while (csz > cnt) {
    res += s[sz - csz];
    --csz;
  }
  for (int i = sz - csz; i < sz; ++i) {
    res += s[i];
    res += '0';
  }
  return stoll(res) % MOD;
}
long long right(const string& s, int cnt) {
  if (s.size() == 10 && (cnt == 9 || cnt == 10)) return MOD19;
  int sz = s.size();
  int csz = sz;
  string res = "";
  while (csz > cnt) {
    res += s[sz - csz];
    --csz;
  }
  for (int i = sz - csz; i < sz; ++i) {
    res += '0';
    res += s[i];
  }
  return stoll(res) % MOD;
}
int main() {
  string s = "1000000000";
  left(s, 9);
  left(s, 10);
  right(s, 9);
  right(s, 10);
  int n;
  cin >> n;
  vector<string> a(n);
  vector<int> cnt(11);
  for (int i = 0; i < n; ++i) {
    cin >> a[i];
    ++cnt[a[i].size()];
  }
  long long res = 0;
  for (int i = 0; i < n; ++i) {
    for (int j = 1; j <= 10; ++j) {
      if (cnt[j]) {
        res += (left(a[i], j) + right(a[i], j)) * cnt[j];
        res %= MOD;
      }
    }
  }
  cout << res << endl;
  return 0;
}
