#include <bits/stdc++.h>
using namespace std;
int main() {
  int x;
  while (cin >> x) {
    map<char, int> p1;
    string str, strr;
    ;
    bool l = 0;
    int sum;
    cin >> str;
    for (int i = 0; i < str.size(); i++) {
      p1[str[i]]++;
    }
    for (int i = 0; i < str.size(); i++) {
      if (p1[str[i]] % x != 0) {
        l = 1;
        break;
      }
    }
    if (l == 0) {
      for (char i = 'a'; i <= 'z'; i++) {
        sum = 0;
        if (p1[i] > 0) {
          sum = p1[i] / x;
        }
        while (sum--) {
          strr += i;
        }
      }
      while (x--) {
        cout << strr;
      }
    } else
      cout << -1;
    cout << endl;
  }
}
