#include <bits/stdc++.h>
using namespace std;
string s;
int x, a = 1, b, tmp;
vector<int> manf;
bool flg;
int main() {
  getline(cin, s);
  for (int i = 2; i < s.length(); i += 2) {
    if (s[i] == '+')
      a++;
    else if (s[i] == '-')
      b++;
    else if (s[i] == '=') {
      for (int j = i + 2; j < s.length(); j++) x = x * 10 + (s[j] - '0');
      break;
    }
  }
  if (a * x < x + b || a > x + b * x) {
    cout << "Impossible";
    return 0;
  }
  if (a - b > x) {
    tmp = a - x;
    for (int i = 0; i < b; i++) {
      manf.push_back(min(x, tmp - b + i + 1));
      tmp -= min(x, tmp - b + i + 1);
    }
    tmp = a - x;
  } else {
    tmp = b;
    for (int i = 0; i < b; i++) manf.push_back(1);
  }
  tmp += x;
  cout << "Possible" << endl;
  for (int i = 0; i < s.length(); i += 2) {
    if (s[i] == '?') {
      if (flg) {
        cout << manf.back() << " ";
        manf.pop_back();
      } else {
        a--;
        cout << min(x, tmp - a) << " ";
        tmp -= min(x, tmp - a);
      }
    } else if (s[i] == '+') {
      flg = 0;
      cout << s[i] << " ";
    } else if (s[i] == '-') {
      flg = 1;
      cout << s[i] << " ";
    } else if (s[i] == '=') {
      cout << "= " << x;
      break;
    }
  }
  return 0;
}
