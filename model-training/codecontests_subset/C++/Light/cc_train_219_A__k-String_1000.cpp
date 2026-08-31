#include <bits/stdc++.h>
using namespace std;
string repeat(string s, int K) {
  string r = "";
  for (int x = 0; x < K; x++) {
    r += s;
  }
  return r;
}
int main() {
  int K;
  cin >> K;
  string s;
  cin >> s;
  int fr[26];
  memset(fr, 0, sizeof(fr));
  for (int x = 0; x < s.length(); x++) fr[s[x] - 'a']++;
  bool p = 1;
  string rep = "";
  for (int x = 0; x < 26; x++) {
    if (fr[x] % K == 0) {
      rep += string(fr[x] / K, (char)(x + 'a'));
    } else {
      p = false;
    }
  }
  if (p)
    cout << repeat(rep, K) << endl;
  else
    cout << -1 << endl;
  return 0;
}
