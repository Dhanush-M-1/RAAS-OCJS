#include <bits/stdc++.h>
using namespace std;
int main() {
  set<string> victims;
  string p1, p2;
  cin >> p1 >> p2;
  victims.insert(p1);
  victims.insert(p2);
  cout << p1 << " " << p2 << endl;
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> p1 >> p2;
    victims.erase(p1);
    set<string>::iterator iter = victims.begin();
    cout << *iter << " ";
    cout << p2 << endl;
    victims.insert(p2);
  }
  return 0;
}
