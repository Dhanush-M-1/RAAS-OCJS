#include <bits/stdc++.h>
using namespace std;
const int M = 1e9 + 7;
long long bpw(long long a, long long b) {
  long long ans = 1;
  while (b > 0) {
    if (b % 2) ans = (ans * a) % M;
    a = (a * a) % M;
    b >>= 1;
  }
  return ans;
}
bool isPerfectSquare(int n) {
  int x = sqrt(n);
  return (x * x == n);
}
void sail() {
  string s;
  cin >> s;
  int n = s.size();
  if (n == 1) {
    cout << s << '\n';
  } else {
    vector<int> v;
    for (int i = 0; i < n; ++i) {
      if (s[i] == '+') {
        continue;
      } else {
        v.push_back(s[i] - '0');
      }
    }
    sort(v.begin(), v.end());
    string ans = "";
    for (int i = 0; i < v.size(); ++i) {
      ans = ans + (char)(v[i] + '0') + "+";
    }
    cout << ans.substr(0, n) << '\n';
  }
}
int main() {
  ios_base ::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int t = 1;
  while (t--) {
    sail();
  }
}
