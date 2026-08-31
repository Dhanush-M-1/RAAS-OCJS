#include <bits/stdc++.h>
using namespace std;
const int N = 110;
int mem[N];
void def(const int& m) {
  int j, k, id;
  int cnt1;
  for (int i = (int)(0); i < (int)(m); ++i) {
    if (mem[i] == -1) {
      cnt1 = 0;
      for (j = i; mem[j] == -1 and j < m; j++)
        ;
      id = mem[j];
      if (mem[j] == -1 or j == m) break;
      for (k = j; mem[k] == id; k++) {
        cnt1 += 1;
        mem[k] = -1;
      }
      for (j = i; j < i + cnt1; j++) {
        mem[j] = id;
      }
      i = j - 1;
    }
  }
}
string itoa(int a) {
  string ret = "";
  while (a) {
    int v = a % 10;
    ret += char(v + '0');
    a /= 10;
  }
  reverse((ret).begin(), (ret).end());
  return ret;
}
string all(const int& m, int& id, const int& val) {
  if (val > m) return "NULL";
  for (int i = (int)(0); i < (int)(m); ++i) {
    if (mem[i] == -1) {
      int cnt = 0;
      for (int j = i; mem[j] == -1 and j < m; j++) {
        cnt += 1;
      }
      if (cnt >= val) {
        for (int j = i; j < i + val; j++) {
          mem[j] = id;
        }
        id += 1;
        return itoa(id - 1);
      }
    }
  }
  return "NULL";
}
string era(const int& m, const int& id, int val) {
  if (val >= id or val <= 0) return "ILLEGAL_ERASE_ARGUMENT";
  bool flag = true;
  for (int i = (int)(0); i < (int)(m); ++i) {
    if (mem[i] == val) {
      flag = false;
      mem[i] = -1;
    }
  }
  if (flag) return "ILLEGAL_ERASE_ARGUMENT";
  return "-1";
}
int main() {
  int t, m, val;
  int id = 1;
  string cmd;
  cin >> t >> m;
  for (int i = (int)(0); i < (int)(m); ++i) mem[i] = -1;
  for (int i = (int)(0); i < (int)(t); ++i) {
    cin >> cmd;
    if (cmd == "defragment") {
      def(m);
    } else {
      cin >> val;
      if (cmd == "alloc") {
        cout << all(m, id, val) << endl;
      } else {
        string tmp = era(m, id, val);
        if (tmp != "-1") cout << tmp << endl;
      }
    }
  }
  return 0;
}
