#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC optimize("-ffloat-store")
#pragma GCC target("avx,avx2,fma")
#pragma GCC optimization("unroll-loops")
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ;
  int k;
  cin >> k;
  unordered_map<char, int> m;
  string s;
  cin >> s;
  for (int i = 0; i < s.length(); i++) {
    m[s[i]]++;
  }
  int flag = 0;
  for (auto i : m) {
    if (i.second % k != 0) {
      flag = 1;
      break;
    }
  }
  string ans = "";
  if (flag == 0) {
    for (auto i : m) {
      for (int j = 0; j < i.second / k; j++) ans += i.first;
    }
    for (int i = 0; i < k; i++) {
      cout << ans;
    }
  } else
    cout << "-1";
  return 0;
}
