#include <bits/stdc++.h>
using namespace std;
void input() {}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  input();
  int n, k;
  cin >> k;
  string str, ans = "";
  cin >> str;
  n = str.length();
  map<char, int> m;
  if (n == 1)
    cout << str;
  else if (n % k != 0)
    cout << -1;
  else {
    int flag = 1;
    for (long long int i = 0; i < n; i++) m[str[i]]++;
    for (auto j : m) {
      if (j.second % k != 0) {
        flag = 0;
        break;
      } else {
        string temp(j.second / k, j.first);
        ans += temp;
      }
    }
    if (flag) {
      for (long long int i = 0; i < n / ans.length(); i++) cout << ans;
    } else
      cout << -1;
  }
}
