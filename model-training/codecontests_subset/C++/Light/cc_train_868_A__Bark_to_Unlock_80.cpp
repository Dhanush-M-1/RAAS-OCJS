#include <bits/stdc++.h>
using namespace std;
int main() {
  string key;
  cin >> key;
  int t;
  cin >> t;
  vector<string> barks;
  for (int i = 0; i < t; i++) {
    string bark;
    cin >> bark;
    barks.push_back(bark);
  }
  bool ans = false;
  for (int i = 0; i < barks.size(); i++) {
    if (barks[i] == key) ans = true;
  }
  for (int i = 0; i < barks.size(); i++) {
    for (int j = 0; j < barks.size(); j++) {
      string test;
      test = barks[i] + barks[j];
      if (test.find(key) != string::npos) {
        ans = true;
      }
    }
  }
  if (ans)
    cout << "YES";
  else
    cout << "NO";
}
