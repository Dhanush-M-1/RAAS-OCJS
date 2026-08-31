#include <bits/stdc++.h>
using namespace std;
int main() {
  char c;
  int pos = 1, neg = 0;
  string s = "+";
  while (scanf("%c", &c) && c != '=') {
    if (c == '+')
      pos += 1, s += '+';
    else if (c == '-') {
      neg += 1, s += '-';
    }
  }
  int n;
  cin >> n;
  if (n * pos - neg < n || pos - neg * n > n)
    cout << "Impossible";
  else {
    bool flag = false;
    int total = n * pos - neg - n;
    int vpos[pos], vneg[neg];
    for (int i = 0; i < pos; i++) {
      vpos[i] = n;
    }
    for (int i = 0; i < neg; i++) {
      vneg[i] = 1;
    }
    for (int i = 0; i < pos; i++) {
      if (total - (n - 1) >= 0)
        vpos[i] = 1, total -= (n - 1);
      else {
        vpos[i] = n - total;
        flag = true;
        break;
      }
    }
    if (flag == false) {
      for (int i = 0; i < neg; i++) {
        if (total - (n - 1) >= 0)
          vneg[i] = n, total -= (n - 1);
        else {
          vneg[i] = total + 1;
          total = 0;
          break;
        }
      }
    }
    int ps = 0;
    int ns = 0;
    bool flag1 = false;
    cout << "Possible" << endl;
    for (int i = 0; i < neg + pos; i++) {
      if (s[i] == '+') {
        if (flag1 == true) cout << "+ " << vpos[ps] << " ", ps += 1;
        if (flag1 == false) {
          cout << vpos[ps] << " ", ps += 1;
          flag1 = true;
        }
      }
      if (s[i] == '-') cout << "- " << vneg[ns] << " ", ns += 1;
    }
    cout << "= " << n;
  }
}
