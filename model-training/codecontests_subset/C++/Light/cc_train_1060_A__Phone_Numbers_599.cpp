#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int t, k, cnt = 0;
  string s;
  cin >> t;
  cin >> s;
  k = ceil(t / 11);
  for (int i = 0; i < t; i++) {
    if (s[i] == '8') cnt++;
  }
  cout << min(k, cnt);
  return 0;
}
