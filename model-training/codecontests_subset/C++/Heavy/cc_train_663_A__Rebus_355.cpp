#include <bits/stdc++.h>
using namespace std;
char c1[10000000];
string s;
int n, numM, numS;
stack<string> conA, conB;
string convert_string(int m) {
  string res = "";
  while (m != 0) {
    res = (char)(m % 10 + '0') + res;
    m /= 10;
  }
  return res;
}
int main() {
  getline(cin, s);
  int t = s.length() - 1;
  while (s[t - 1] != ' ') t--;
  for (int i = t; i < s.length(); i++) n = n * 10 + (s[i] - '0');
  numS = 1;
  numM = 0;
  for (int i = 0; i < s.length(); i++) {
    if (s[i] == '+') numS++;
    if (s[i] == '-') numM++;
  }
  bool res = true;
  int num1, num0 = numM, carryN = n;
  while ((num0 > 0) && ((n + num0) < numS)) {
    num0--;
    n += carryN;
    conB.push(convert_string(carryN));
  }
  n += num0;
  while (num0--) {
    conB.push(convert_string(1));
  }
  t = n / numS;
  if (t == 0) {
    res = false;
  } else {
    if (t > carryN) {
      res = false;
    } else {
      if (n % numS != 0) {
        if (t + 1 > carryN) {
          res = false;
        } else {
          num1 = n % numS;
        }
      }
    }
  }
  if (res) {
    cout << "Possible\n";
    string ss = "";
    numS -= num1;
    while (num1--) {
      conA.push(convert_string(t + 1));
    }
    while (numS--) conA.push(convert_string(t));
    ss += conA.top();
    conA.pop();
    for (int i = 1; i < s.length(); i++) {
      if (s[i] == '?') {
        if (s[i - 2] == '+') {
          ss += conA.top();
          conA.pop();
        } else {
          ss += conB.top();
          conB.pop();
        }
      } else {
        ss += s[i];
      }
    }
    cout << ss << endl;
  } else {
    cout << "Impossible" << endl;
  }
}
