#include <bits/stdc++.h>
using namespace std;
vector<int> va, vb;
int main() {
  string s;
  getline(cin, s);
  int n = 0;
  int a = 1, b = 0;
  for (int i = 0; i < (int)s.size(); i++) {
    if (s[i] >= '0' && s[i] <= '9') n = n * 10 + s[i] - '0';
    if (s[i] == '-') b++;
    if (s[i] == '+') a++;
  }
  for (int i = 0; i < a; i++) va.push_back(1);
  for (int i = 0; i < b; i++) vb.push_back(1);
  int now = a - b;
  int it = 0;
  while (now < n) {
    if (it == (int)va.size()) {
      cout << "Impossible";
      return 0;
    }
    if (va[it] + n - now > n) {
      now = now - va[it] + n;
      va[it] = n;
      it++;
    } else {
      va[it] += n - now;
      now = n;
    }
  }
  while (now > n) {
    if (it == (int)vb.size()) {
      cout << "Impossible";
      return 0;
    }
    if (vb[it] - n + now > n) {
      now = now + vb[it] - n;
      vb[it] = n;
      it++;
    } else {
      vb[it] += -n + now;
      now = n;
    }
  }
  cout << "Possible\n";
  int u = 0, d = 0;
  now = 1;
  for (int i = 0; i < (int)s.size(); i++) {
    if (s[i] == '?') {
      if (now == 1) {
        cout << va[u];
        u++;
      } else {
        cout << vb[d];
        d++;
      }
      continue;
    }
    if (s[i] == '+') now = 1;
    if (s[i] == '-') now = 0;
    cout << s[i];
  }
  return 0;
}
