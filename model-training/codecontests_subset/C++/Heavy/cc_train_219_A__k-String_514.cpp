#include <bits/stdc++.h>
#pragma GCC optimize("Ofast,no-stack-protector,unroll-loops,fast-math,O3")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
const int N = 2e5 + 5;
using namespace std;
int main() {
  int k, cnt = 0;
  char c;
  cin >> k;
  string s;
  cin >> s;
  int l = s.size();
  sort(s.begin(), s.begin() + s.size());
  for (int i = 0; i < l; i++) {
    if (i % k == 0) {
      c = s[i];
    }
    if (s[i] == c) {
      cnt++;
    }
  }
  if (l == cnt && cnt % k == 0) {
    for (int i = 0; i < k; i++) {
      for (int l = 0; l < s.size(); l += k) {
        cout << s[l];
      }
    }
  } else
    cout << "-1";
}
