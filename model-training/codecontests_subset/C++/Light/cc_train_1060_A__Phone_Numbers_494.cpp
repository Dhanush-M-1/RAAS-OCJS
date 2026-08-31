#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long n, ans = 0;
  cin >> n;
  string s;
  cin >> s;
  for (long long i = 0; i < s.length(); i++) {
    if (s[i] == '8') ans++;
  }
  cout << min(n / 11, ans);
}
