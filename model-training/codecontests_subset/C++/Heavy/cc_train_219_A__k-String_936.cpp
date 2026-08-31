#include <bits/stdc++.h>
using namespace std;
int main() {
  int k, i, status, p, j;
  map<char, int> m;
  map<char, int>::iterator it;
  string s, a;
  cin >> k;
  cin >> s;
  for (i = 0; i < s.length(); i++) {
    m[s[i]]++;
  }
  p = 0;
  status = 1;
  for (it = m.begin(); it != m.end(); it++) {
    if (it->second % k == 0) {
      for (i = p; i < p + ((it->second) / k); i++) {
        a[i] = it->first;
      }
      p = i;
    } else {
      status = 0;
      break;
    }
  }
  a[p] = '\0';
  if (status == 1) {
    for (i = 0; i < k; i++) {
      for (j = 0; j < p; j++) cout << a[j];
    }
    exit(0);
  } else
    cout << "-1";
  return 0;
}
