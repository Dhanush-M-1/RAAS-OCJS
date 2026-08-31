#include <bits/stdc++.h>
using namespace std;
long long a, b, c;
string s;
int cnt, ans;
int main() {
  ;
  ios_base::sync_with_stdio(0);
  cin >> a;
  cin >> s;
  for (int i = 0; i < s.size(); i++) {
    if (s[i] == '8') cnt++;
  }
  ans = s.size() / 11;
  if (ans != 0 and cnt != 0) {
    cout << min(ans, cnt);
  } else {
    cout << 0;
  }
}
