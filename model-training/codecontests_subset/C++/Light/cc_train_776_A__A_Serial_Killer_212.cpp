#include <bits/stdc++.h>
using namespace std;
int main() {
  string first, second;
  int n;
  cin >> first >> second >> n;
  cout << first << ' ' << second << endl;
  for (int i = 0; i < n; i++) {
    string m, r;
    cin >> m >> r;
    if (first == m)
      first = r;
    else
      second = r;
    cout << first << ' ' << second << endl;
  }
}
