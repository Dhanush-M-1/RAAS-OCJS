#include <bits/stdc++.h>
using namespace std;
set<string> ss;
string str;
int n;
int main() {
  cin >> str;
  ss.insert(str);
  cin >> str;
  ss.insert(str);
  cin >> n;
  for (set<string>::iterator itor = ss.begin(); itor != ss.end(); itor++)
    cout << *itor << " ";
  cout << endl;
  for (int i = 1; i <= n; i++) {
    cin >> str;
    ss.erase(ss.find(str));
    cin >> str;
    ss.insert(str);
    for (set<string>::iterator itor = ss.begin(); itor != ss.end(); itor++)
      cout << *itor << " ";
    cout << endl;
  }
  return 0;
}
