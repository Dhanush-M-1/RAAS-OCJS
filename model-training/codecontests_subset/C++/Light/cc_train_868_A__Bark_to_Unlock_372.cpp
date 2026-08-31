#include <bits/stdc++.h>
long long poss[26][2];
signed main() {
  std::string s;
  std::cin >> s;
  long long n;
  std::cin >> n;
  for (long long i = 0; i < n; i++) {
    std::string t;
    std::cin >> t;
    if (t == s) {
      std::cout << "YES";
      return 0;
    }
    for (long long j = 0; j < 2; j++) poss[t[j] - 'a'][j] = true;
  }
  if (poss[s[1] - 'a'][0] && poss[s[0] - 'a'][1])
    std::cout << "YES";
  else
    std::cout << "NO";
  return 0;
}
