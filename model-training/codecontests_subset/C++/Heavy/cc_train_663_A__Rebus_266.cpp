#include <bits/stdc++.h>
using namespace std;
int pos_num = 0, neg_num = 0, res = 0;
void analysis(string str) {
  int now = 1;
  for (int i = 0; i < str.size(); i++) {
    if (str[i] == '?') {
      if (now == 1)
        pos_num++;
      else if (now == -1)
        neg_num++;
    } else if (str[i] == '+')
      now = 1;
    else if (str[i] == '-')
      now = -1;
    else if (str[i] == '=') {
      res = 0;
      for (int j = i + 1; j < str.size(); j++) {
        char c = str[j];
        if ('0' <= c && c <= '9') {
          res = res * 10 + c - '0';
        }
      }
      break;
    }
  }
}
void work_in(string str) {
  int pos_l = pos_num, pos_r = pos_num * res;
  int neg_l = neg_num, neg_r = neg_num * res;
  int pos = res, neg = 0;
  if (pos < pos_l) {
    int d = pos_l - pos;
    pos += d;
    neg += d;
  }
  if (neg < neg_l) {
    int d = neg_l - neg;
    pos += d;
    neg += d;
  }
  assert(pos <= pos_r && neg <= neg_r);
  cout << "Possible" << endl;
  pos -= pos_num, neg -= neg_num;
  int sig = 1;
  for (int i = 0; i < str.size(); i++) {
    if (str[i] != '?') cout << str[i];
    if (str[i] == '+')
      sig = 1;
    else if (str[i] == '-')
      sig = -1;
    else if (str[i] == '?') {
      if (sig == 1) {
        int d = min(res - 1, pos);
        cout << 1 + d;
        pos -= d;
      } else if (sig == -1) {
        int d = min(res - 1, neg);
        cout << 1 + d;
        neg -= d;
      }
    }
  }
}
const int MAXL = 1000;
char line[MAXL];
int main(void) {
  cin.getline(line, MAXL);
  analysis(line);
  int mxres = pos_num * res - neg_num;
  int mnres = pos_num - res * neg_num;
  if (!(mnres <= res && res <= mxres)) {
    cout << "Impossible" << endl;
  } else {
    work_in(line);
  }
  return 0;
}
