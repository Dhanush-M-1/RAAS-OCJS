#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  vector<bool> pos;
  bool p = true;
  int cp = 0;
  int n;
  while (true) {
    string s;
    cin >> s;
    if (s == "=") {
      cin >> n;
      break;
    }
    if (s == "+") {
      p = true;
    }
    if (s == "-") {
      p = false;
    }
    if (s == "?") {
      pos.push_back(p);
      if (p) {
        cp++;
      }
    }
  }
  int cn = pos.size() - cp;
  int mx = cp * n - cn;
  int mn = -cn * n + cp;
  if (n > mx || n < mn) {
    cout << "Impossible";
    return 0;
  }
  cout << "Possible\n";
  int c = 0;
  for (int i = 0; i < pos.size(); i++) {
    p = pos[i];
    if (p) {
      cp--;
      int l = n - c;
      int d = cp - cn;
      int t = min(n, max(1, l - d));
      c += t;
      if (i != 0) {
        cout << " + ";
      }
      cout << t;
    } else {
      cn--;
      int l = n - c;
      int d = cp - cn;
      int t = min(n, max(1, d - l));
      c -= t;
      cout << " - ";
      cout << t;
    }
  }
  cout << " = " << n;
  return 0;
}
