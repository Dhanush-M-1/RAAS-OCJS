#include <bits/stdc++.h>
using namespace std;
using LL = int64_t;
const int INF = 0x3f3f3f3f;
const int maxn = 1e6 + 5;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  string s;
  int num[100];
  cin >> s;
  int cnt = 0;
  for (int i = 0; i < s.length(); i += 2) {
    num[cnt++] = s[i] - '0';
  }
  sort(num, num + cnt);
  for (int i = 0; i < cnt; i++) {
    if (i) cout << '+';
    cout << num[i];
  }
  return 0;
}
