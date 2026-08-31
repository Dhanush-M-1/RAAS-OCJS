#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long i, j, n, t = 1, k = 0, cnt = 0, mini = LLONG_MAX, maxi = LLONG_MIN,
                     ans = 0;
  long long m;
  string a, b;
  cin >> a >> b;
  cin >> n;
  cout << a << " " << b << '\n';
  for (i = 0; i < n; i++) {
    string s, f;
    cin >> s >> f;
    if (a == s)
      a = f;
    else
      b = f;
    cout << a << " " << b << '\n';
  }
  return 0;
}
