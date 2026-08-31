#include <bits/stdc++.h>
using namespace std;
int main() {
  string a, b;
  list<string> l;
  string res = "";
  int n;
  cin >> a >> b;
  l.push_back(a);
  l.push_back(b);
  cin >> n;
  for (int i = 0; i < n; i++) {
    string killed, potential;
    cin >> killed >> potential;
    for (list<string>::iterator it = l.begin(); it != l.end(); it++) {
      res += *it + " ";
    }
    res += "\n";
    l.remove(killed);
    l.push_back(potential);
  }
  for (list<string>::iterator it = l.begin(); it != l.end(); it++) {
    res += *it + " ";
  }
  res += "\n";
  cout << res;
  return 0;
}
