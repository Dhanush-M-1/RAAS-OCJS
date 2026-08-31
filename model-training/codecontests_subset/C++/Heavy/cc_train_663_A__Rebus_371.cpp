#include <bits/stdc++.h>
using namespace std;
int main() {
  string s = "";
  char tmp;
  int pos = 0, neg = 0, ques = 0;
  while (scanf("%c", &tmp) != -1 && tmp != '=') {
    if (tmp == '+')
      pos++;
    else if (tmp == '-')
      neg++;
    else if (tmp == '?')
      ques++;
    s += tmp;
  }
  int n;
  scanf("%d", &n);
  pos = ques - neg;
  int plusVal = n + neg;
  int each = 0, leftOver = 0;
  if (pos > 0) {
    each = plusVal / pos;
    leftOver = plusVal % pos;
  }
  vector<int> v;
  int possible = true;
  bool possible1 = true, possible2 = true;
  if (pos <= 0) {
    possible = false;
    possible1 = false;
  }
  if (!possible) {
    possible1 = false;
    possible2 = false;
  }
  for (int i = 0; i < pos && possible && possible1; i++) {
    if (leftOver > 0) {
      v.push_back(each + 1);
      leftOver--;
    } else {
      v.push_back(each);
    }
    if (v[i] > n || v[i] <= 0) {
      possible1 = false;
      break;
    }
  }
  int negVal = pos - n;
  each = 0;
  leftOver = 0;
  if (neg > 0) {
    each = negVal / neg;
    leftOver = negVal % neg;
  }
  vector<int> v2;
  if (neg == 0) possible2 = false;
  for (int i = 0; i < neg && possible && !possible1 && possible2; i++) {
    if (leftOver > 0) {
      v2.push_back(each + 1);
      leftOver--;
    } else {
      v2.push_back(each);
    }
    if (v2[i] > n || v2[i] <= 0) {
      possible2 = false;
      break;
    }
  }
  int ptr = 0;
  if (!possible) {
    cout << "Impossible\n";
  } else {
    if (possible1 || possible2) {
      cout << "Possible" << endl;
      int current = 1;
      for (int i = 0; i < s.length() && possible1; i++) {
        if (s[i] == '-') {
          current = 0;
        } else if (s[i] == '+') {
          current = 1;
        }
        if (s[i] != '?') {
          cout << s[i];
        } else {
          if (current == 0) {
            cout << 1;
          } else {
            cout << v[ptr];
            ptr++;
          }
        }
      }
      ptr = 0;
      current = 1;
      for (int i = 0; i < s.length() && possible2 && !possible1; i++) {
        if (s[i] == '-') {
          current = 0;
        } else if (s[i] == '+') {
          current = 1;
        }
        if (s[i] != '?') {
          cout << s[i];
        } else {
          if (current == 0) {
            cout << v2[ptr];
            ptr++;
          } else {
            cout << 1;
          }
        }
      }
      cout << "= " << n << endl;
    } else
      cout << "Impossible" << endl;
  }
}
