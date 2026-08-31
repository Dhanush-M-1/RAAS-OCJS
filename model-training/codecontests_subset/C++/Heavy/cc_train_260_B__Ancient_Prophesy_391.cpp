#include <bits/stdc++.h>
using namespace std;
bool validate(string temp) {
  if (temp[0] == '-' || temp[1] == '-' || temp[2] != '-' || temp[3] == '-' ||
      temp[4] == '-' || temp[5] != '-')
    return false;
  string d = "", m = "";
  d += temp[0];
  d += temp[1];
  m += temp[3];
  m += temp[4];
  int mm = atoi(m.c_str());
  int dd = atoi(d.c_str());
  if (mm > 12 || mm < 1) return false;
  switch (mm) {
    case 1:
      if (!(dd <= 31 && dd >= 1)) return false;
      break;
    case 2:
      if (!(dd <= 28 && dd >= 1)) return false;
      break;
    case 3:
      if (!(dd <= 31 && dd >= 1)) return false;
      break;
    case 4:
      if (!(dd <= 30 && dd >= 1)) return false;
      break;
    case 5:
      if (!(dd <= 31 && dd >= 1)) return false;
      break;
    case 6:
      if (!(dd <= 30 && dd >= 1)) return false;
      break;
    case 7:
      if (!(dd <= 31 && dd >= 1)) return false;
      break;
    case 8:
      if (!(dd <= 31 && dd >= 1)) return false;
      break;
    case 9:
      if (!(dd <= 30 && dd >= 1)) return false;
      break;
    case 10:
      if (!(dd <= 31 && dd >= 1)) return false;
      break;
    case 11:
      if (!(dd <= 30 && dd >= 1)) return false;
      break;
    case 12:
      if (!(dd <= 31 && dd >= 1)) return false;
      break;
  }
  return true;
}
int main() {
  string in;
  cin >> in;
  string x = "2013", y = "2014", z = "2015";
  map<string, int> X;
  for (int i = 0; i < in.size(); i++) {
    string temp = in.substr(i, 4);
    if (strcmp(temp.c_str(), x.c_str()) == 0) {
      temp = in.substr(i - 6, 10);
      if (validate(temp)) {
        if (X.find(temp) == X.end()) {
          X[temp] = 1;
        } else
          X[temp]++;
      }
    }
    if (strcmp(temp.c_str(), y.c_str()) == 0) {
      temp = in.substr(i - 6, 10);
      if (validate(temp)) {
        if (X.find(temp) == X.end()) {
          X[temp] = 1;
        } else
          X[temp]++;
      }
    }
    if (strcmp(temp.c_str(), z.c_str()) == 0) {
      temp = in.substr(i - 6, 10);
      if (validate(temp)) {
        if (X.find(temp) == X.end()) {
          X[temp] = 1;
        } else
          X[temp]++;
      }
    }
  }
  map<string, int>::iterator it, ret;
  int max = 0;
  for (it = X.begin(); it != X.end(); it++) {
    if ((*it).second > max) {
      max = (*it).second;
      ret = it;
    }
  }
  cout << (*ret).first << endl;
  return 0;
}
