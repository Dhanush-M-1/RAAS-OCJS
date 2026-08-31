#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(NULL);
  cout.tie(NULL);
  vector<string> a;
  string s;
  int k1 = 1, k2 = 0;
  int n;
  vector<int> p1, p2;
  p1.push_back(1);
  while (cin >> s) {
    a.push_back(s);
    if (s == "+") {
      k1++;
      p1.push_back(1);
    }
    if (s == "-") {
      k2++;
      p2.push_back(1);
    }
    if (s == "=") break;
  }
  cin >> s;
  a.push_back(s);
  n = atoi(s.c_str());
  int summ = k1 - k2;
  for (int i = (0); i < (p1.size()); i++) {
    while (summ < n && p1[i] < n) {
      p1[i]++;
      summ++;
    }
  }
  for (int i = (0); i < (p2.size()); i++) {
    while (summ > n && p2[i] < n) {
      p2[i]++;
      summ--;
    }
  }
  if (summ != n) {
    cout << "Impossible" << '\n';
    return 0;
  }
  cout << "Possible" << '\n';
  int pp1 = 0, pp2 = 0;
  for (int i = (0); i < (a.size()); i++) {
    if (a[i] == "?") {
      if (!i || a[i - 1] == "+") {
        cout << p1[pp1] << " ";
        pp1++;
      } else {
        cout << p2[pp2] << " ";
        pp2++;
      }
      continue;
    }
    cout << a[i] << " ";
  }
  cout << '\n';
  return 0;
}
