#include <bits/stdc++.h>
using namespace std;
int get(string s) {
  int a = 0;
  for (int i = 0; i < s.size(); ++i) {
    if (s[i] == ' ') continue;
    a *= 10;
    a += (s[i] - '0');
  }
  return a;
}
signed main() {
  std::ios_base::sync_with_stdio(0), cin.tie(0);
  vector<int> a;
  int pos = 1, neg = 0;
  a.push_back(1);
  string s;
  getline(cin, s);
  int n = 0;
  for (int i = 0; i < s.size(); ++i) {
    char u = s[i];
    if (u == ' ') continue;
    if (u == '=') {
      string cur = s.substr(i + 2);
      n = get((cur));
      break;
    } else if (u == '?')
      continue;
    else if (u == '-')
      neg++, a.push_back(-1);
    else if (u == '+')
      pos++, a.push_back(1);
  }
  int mn = pos - n * neg, mx = n * pos - neg;
  if (!(mn <= n && n <= mx)) {
    cout << "Impossible";
    return 0;
  }
  cout << "Possible\n";
  string ans;
  int sum = 0;
  for (int i = 0; i < a.size(); ++i) {
    if (a[i] == 1) {
      pos--;
    } else {
      neg--;
    }
    for (int x = 1; x <= n; ++x) {
      if (sum + x * a[i] + pos - n * neg <= n &&
          n <= sum + x * a[i] + pos * n - neg) {
        ans += to_string(x);
        if (i != a.size() - 1) {
          ans += ' ';
          if (a[i + 1] == 1)
            ans += "+ ";
          else
            ans += "- ";
        } else
          ans += ' ';
        sum += a[i] * x;
        break;
      }
    }
  }
  ans += "= ";
  ans += to_string(n);
  cout << ans;
  return 0;
}
