#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int i, j, n;
  cin >> n;
  string s;
  bool f = 0;
  cin >> s;
  if (s.size() % n != 0)
    cout << -1 << endl;
  else {
    map<char, long long int> mm;
    for (int i = 0; i < s.size(); i++) {
      mm[s[i]]++;
    }
    map<char, long long int>::iterator it;
    for (it = mm.begin(); it != mm.end(); it++) {
      if (it->second % n != 0) {
        f = 1;
        cout << -1 << endl;
        break;
      }
    }
    if (f == 0) {
      string a = "";
      for (it = mm.begin(); it != mm.end(); it++) {
        int c = it->second / n;
        while (c) {
          a += it->first;
          c--;
        }
      }
      while (n--) {
        cout << a;
      }
      cout << endl;
    }
  }
  return 0;
}
