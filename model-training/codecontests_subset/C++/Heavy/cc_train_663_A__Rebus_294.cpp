#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  string str;
  int n = 0;
  getline(cin, str);
  int at;
  for (at = str.size() - 1; str[at] != ' '; at--)
    ;
  for (int i = at + 1; i < str.size(); i++) n = (n * 10) + (str[i] - '0');
  int num = 0, neg = 0, pos;
  for (int i = 0; i < str.size(); i++) {
    if (str[i] == '?') num++;
    if (str[i] == '-') neg++;
  }
  pos = num - neg;
  if (pos * n - neg < n || pos - neg * n > n)
    cout << "Impossible\n";
  else {
    cout << "Possible\n";
    char ch = '+';
    int target = n + neg;
    int cont = 0;
    int fim = target % pos;
    int rest = target / pos;
    if (rest == 0) {
      target = pos - n;
      fim = target % neg;
      rest = target / neg;
      for (int i = 0; i < str.size(); i++) {
        if (str[i] == '?') {
          if (ch == '+')
            cout << '1';
          else if (cont < fim) {
            cout << rest + 1;
            cont++;
          } else
            cout << rest;
        } else {
          cout << str[i];
          if (str[i] == '-') ch = '-';
          if (str[i] == '+') ch = '+';
        }
      }
    } else {
      for (int i = 0; i < str.size(); i++) {
        if (str[i] == '?') {
          if (ch == '-')
            cout << '1';
          else if (cont < fim) {
            cout << rest + 1;
            cont++;
          } else
            cout << rest;
        } else {
          cout << str[i];
          if (str[i] == '-') ch = '-';
          if (str[i] == '+') ch = '+';
        }
      }
    }
    cout << endl;
  }
  return 0;
}
