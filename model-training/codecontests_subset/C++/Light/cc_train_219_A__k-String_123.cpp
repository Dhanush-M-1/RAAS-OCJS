#include <bits/stdc++.h>
using namespace std;
int main() {
  long long k, i, n, j;
  char c;
  string s, a;
  map<char, long long> m;
  cin >> k >> s;
  n = s.size();
  for (i = 0; i < n; i++) {
    m[s[i]]++;
  }
  for (c = 'a'; c <= 'z'; c++) {
    if (m[c] % k) {
      c = 'A';
      break;
    }
    for (int j = 0; j < m[c] / k; j++) a += c;
  }
  if (c == 'A') {
    cout << -1;
    return 0;
  }
  for (i = 0; i < k; i++) cout << a;
}
