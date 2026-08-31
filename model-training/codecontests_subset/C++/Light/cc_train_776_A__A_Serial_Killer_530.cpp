#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e5 + 10;
const int eps = 1e-14;
const int mod = 1e9 + 7;
const long long inf = 1e18;
int a[maxn];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  string s1, s2;
  cin >> s1 >> s2;
  int n;
  cin >> n;
  cout << s1 << " " << s2 << endl;
  for (int i = 0; i < n; i++) {
    string dead, re;
    cin >> dead >> re;
    if (dead == s1) {
      s1 = re;
    } else {
      s2 = re;
    }
    cout << s1 << " " << s2 << endl;
  }
  return 0;
}
