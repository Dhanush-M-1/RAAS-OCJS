#include <bits/stdc++.h>
using namespace std;
const int mm = 2e5 + 10;
long long a1, a2, a3, a4, a5, a6, a7, a8, a9, ans, ez1, n, m, k;
string s, s1;
int inp[1010];
vector<int> oo;
bool sos(const pair<int, int> &a, const pair<int, int> &b) {
  return (a.first > b.first);
}
void input() {
  cin >> n;
  cin >> s;
  for (int i = 0; i < n; i++) {
    if (s[i] == '8') a1++;
  }
  cout << min(a1, n / 11);
}
void solve() {}
int main() {
  cin.tie(0);
  input();
  solve();
  return 0;
}
