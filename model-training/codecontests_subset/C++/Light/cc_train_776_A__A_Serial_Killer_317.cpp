#include <bits/stdc++.h>
using namespace std;
int main() {
  pair<string, string> p[1002], p1;
  cin >> p1.first >> p1.second;
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> p[i].first >> p[i].second;
  }
  cout << p1.first << " " << p1.second << endl;
  for (int j = 0; j < n; j++) {
    for (int i = 0; i < n; i++) {
      if (p[i].first == p1.first) {
        cout << p[i].second << " " << p1.second << endl;
        p1.first = p[i].second;
        break;
      } else if (p[i].first == p1.second) {
        cout << p1.first << " " << p[i].second << endl;
        p1.second = p[i].second;
        break;
      }
    }
  }
  return 0;
}
