#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  scanf("%d", &n);
  string s, k;
  cin >> s;
  map<char, int> m;
  map<char, int>::iterator it;
  for (int i = 0; i < s.length(); i++) {
    m[s[i]]++;
  }
  string result;
  for (it = m.begin(); it != m.end(); it++) {
    if (it->second % n != 0) {
      cout << -1 << endl;
      return 0;
    } else {
      int z = it->second / n;
      while (z--) k.push_back(it->first);
    }
  }
  while (n--) {
    cout << k;
  }
}
