#include <bits/stdc++.h>
using namespace std;
map<long long int, long long int> mp;
long long int n;
vector<long long int> v;
long long int ans = 0;
long long int strint(string ans) {
  long long int mul = 1;
  long long int ret = 0;
  for (long long int i = 0; i < ans.length(); i++) {
    ret += ((ans[i] - '0') * mul);
    mul *= 10;
    ret %= 998244353;
    mul %= 998244353;
  }
  return ret;
}
string conc(string a, string b) {
  long long int j = b.length() - 1;
  long long int i = a.length() - 1;
  string ans = "";
  bool is = 0;
  for (;;) {
    if (is) {
      if (i < 0) break;
      ans += a[i];
      i--;
    } else {
      if (j < 0) break;
      ans += b[j];
      j--;
    }
    is = !is;
  }
  while (i >= 0) ans += a[i--];
  while (j >= 0) ans += b[j--];
  return ans;
}
long long int calca(long long int num, long long int dig) {
  string s = "";
  while (dig--) s += '0';
  string ans = conc(to_string(num), s);
  return strint(ans);
}
long long int calcb(long long int num, long long int dig) {
  string s = "";
  while (dig--) s += '0';
  string ans = conc(s, to_string(num));
  return strint(ans);
}
long long int siz(long long int num) {
  if (num == 0) return 0;
  return (1 + siz(num / 10));
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  v.resize(n);
  for (long long int i = 0; i < n; i++) {
    cin >> v[i];
    mp[siz(v[i])]++;
  }
  for (long long int i = 0; i < n; i++) {
    for (auto j : mp) {
      ans += ((calca(v[i], j.first) * j.second) % 998244353);
      ans %= 998244353;
      ans += ((calcb(v[i], j.first) * j.second) % 998244353);
      ans %= 998244353;
    }
  }
  cout << ans << "\n";
  return 0;
}
