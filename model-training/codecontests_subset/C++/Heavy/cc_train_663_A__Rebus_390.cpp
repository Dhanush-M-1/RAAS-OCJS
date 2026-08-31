#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  getline(cin, s);
  int pos = 0;
  int neg = 0;
  int i, j;
  int n = (int)s.size();
  int val = 0;
  int count = 0;
  for (i = 0; i < n; i++) {
    if (s[i] == '+') {
      pos++;
    }
    if (s[i] == '-') {
      neg++;
    }
    if (s[i] == '?') count++;
    if (s[i] >= '0' && s[i] <= '9') {
      while (s[i] >= '0' && s[i] <= '9') {
        val = (val * 10) + s[i] - '0';
        i++;
      }
    }
  }
  stack<int> s_pos, s_neg;
  int pos_val = 0, neg_val = 0;
  ;
  while (pos != neg) {
    if (pos > neg) {
      int tm = 0;
      if (neg > 0) tm = 1;
      int cou = min(val, pos - neg + tm);
      if (neg > 0) {
        s_neg.push(cou);
        neg_val += cou;
        neg--;
      }
      while (cou > 0) {
        s_pos.push(1);
        pos_val++;
        pos--;
        cou--;
      }
    } else {
      int tm = 0;
      if (pos > 0) tm = 1;
      int cou = min(val, neg - pos + tm);
      if (pos > 0) {
        s_pos.push(cou);
        pos_val += cou;
        pos--;
      }
      while (cou > 0) {
        s_neg.push(1);
        neg_val++;
        neg--;
        cou--;
      }
    }
  }
  int val2 = val - pos_val + neg_val;
  if (val2 < 1 || val2 > val) {
    cout << "Impossible";
    return 0;
  }
  cout << "Possible\n";
  for (i = 0; i < n; i++) {
    if (s[i] == '?') {
      cout << val2;
      i++;
      break;
    } else {
      cout << s[i];
    }
  }
  int turn = 0;
  for (; i < n; i++) {
    if (s[i] == '?') {
      if (turn > 0 && !s_pos.empty()) {
        cout << s_pos.top();
        s_pos.pop();
      } else if (turn < 0 && !s_neg.empty()) {
        cout << s_neg.top();
        s_neg.pop();
      } else
        cout << "1";
    } else {
      cout << s[i];
    }
    if (s[i] == '+') {
      turn = 1;
    }
    if (s[i] == '-') {
      turn = -1;
    }
  }
}
