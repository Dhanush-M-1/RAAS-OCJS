#include <bits/stdc++.h>
using namespace std;
template <class T>
T GCD(T a, T b) {
  return (b != 0 ? GCD<T>(b, a % b) : a);
}
template <class T>
T LCM(T a, T b) {
  return ((a * b) / GCD<T>(a, b));
}
int main() {
  int k;
  string s, ans = "", res = "";
  cin >> k >> s;
  int l = s.size(), f, cnt;
  if (l % k) cout << -1 << endl, exit(0);
  map<char, int> mp;
  for (int i = 0; i < l; i++) mp[s[i]]++;
  map<char, int>::iterator it;
  for (it = mp.begin(); it != mp.end(); it++) {
    f = it->second;
    if (f % k) cout << -1 << endl, exit(0);
    cnt = f / k;
    for (int i = 0; i < cnt; i++) ans += it->first;
  }
  for (int i = 0; i < k; i++) res += ans;
  cout << res << endl;
  return 0;
}
