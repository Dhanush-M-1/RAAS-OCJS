#include <bits/stdc++.h>
using namespace std;
int main() {
  int k;
  string s, s1;
  cin >> k >> s;
  if (s.size() == 1) {
    cout << s;
    return 0;
  }
  map<char, int> mymap;
  map<char, int>::iterator imap;
  for (int i = 0; i < s.size(); i++) {
    if (!mymap.count(s[i]))
      mymap.insert(pair<char, int>(s[i], 1));
    else {
      imap = mymap.find(s[i]);
      imap->second++;
    }
  }
  for (imap = mymap.begin(); imap != mymap.end(); imap++) {
    if (imap->second % k != 0) {
      cout << -1;
      return 0;
    } else {
      for (int i = 0; i < imap->second / k; i++) s1 += imap->first;
    }
  }
  for (int i = 0; i < k; i++) cout << s1;
}
