#include <bits/stdc++.h>
using namespace std;
const int inf = 1000000007;
const int N = 1000000 + 7;
const int multipleTest = 0;
string x, s[N];
int n;
void solve() {
  cin >> x;
  cin >> n;
  for (int i = (0), _b = (n); i < _b; ++i) cin >> s[i];
  for (int i = (0), _b = (n); i < _b; ++i) {
    if (s[i] == x) {
      puts("YES");
      return;
    }
    for (int j = (0), _b = (n); j < _b; ++j) {
      if (s[i].back() == x[0] && s[j][0] == x[1]) {
        puts("YES");
        return;
      }
    }
  }
  puts("NO");
}
int main() {
  int Test = 1;
  if (multipleTest) {
    cin >> Test;
  }
  for (int i = 0; i < Test; ++i) {
    solve();
  }
}
