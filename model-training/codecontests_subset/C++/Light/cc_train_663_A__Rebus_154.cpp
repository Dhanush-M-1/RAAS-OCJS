#include <bits/stdc++.h>
using namespace std;
long long mod = 1000003;
int main() {
  string s;
  cin >> s;
  std::vector<int> a;
  a.push_back(1);
  cin >> s;
  while (s != "=") {
    if (s == "-")
      a.push_back(-1);
    else
      a.push_back(1);
    cin >> s;
    cin >> s;
  }
  int n;
  cin >> n;
  int ap = 0, am = 0;
  for (auto x : a) {
    if (x > 0)
      ap++;
    else
      am++;
  }
  if (n * ap - am < n)
    cout << "Impossible";
  else if (ap - n * am > n)
    cout << "Impossible";
  else {
    cout << "Possible" << endl;
    int add = n - (ap - am);
    string ans;
    for (int i = 0; i < a.size(); i++) {
      if (i > 0) {
        if (a[i] > 0)
          cout << "+ ";
        else
          cout << "- ";
      }
      if (a[i] > 0) {
        if (add > 0) {
          int d = min(n - 1, add);
          cout << 1 + d << " ";
          add -= d;
        } else
          cout << "1 ";
      }
      if (a[i] < 0) {
        if (add < 0) {
          int d = max(-n + 1, add);
          cout << 1 - d << " ";
          add -= d;
        } else
          cout << "1 ";
      }
    }
    cout << "= " << n << endl;
  }
}
