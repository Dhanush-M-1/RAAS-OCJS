#include <bits/stdc++.h>
using namespace std;
template <class T>
string toString(T n) {
  ostringstream ost;
  ost << n;
  ost.flush();
  return ost.str();
}
long long toInt64(string s) {
  long long r = 0;
  istringstream sin(s);
  sin >> r;
  return r;
}
int main() {
  int t = 0;
  int m = 0;
  char buff[100];
  cin.getline(buff, 100);
  string s(buff);
  istringstream is(s);
  is >> t >> m;
  vector<int> a(m, 0);
  int c = 1;
  for (int i = 0; i < t; ++i) {
    cin.getline(buff, 100);
    s = buff;
    istringstream is2(s);
    string action;
    is2 >> action;
    int n;
    if (action == "alloc") {
      bool find = false;
      int start = -1;
      is2 >> n;
      for (int j = 0; j <= int((a).size()) - n; ++j) {
        if (count(a.begin() + j, a.begin() + j + n, 0) == n) {
          find = true;
          start = j;
          break;
        }
      }
      if (!find) {
        cout << "NULL" << endl;
      } else {
        cout << c << endl;
        for (int j = 0; j < n; ++j) {
          a[start + j] = c;
        }
        c++;
      }
    } else if (action == "erase") {
      is2 >> n;
      if (n == 0 || count((a).begin(), (a).end(), n) == 0) {
        cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
      }
      for (int j = 0; j < int((a).size()); ++j) {
        if (a[j] == n) {
          a[j] = 0;
        }
      }
    } else {
      vector<int> b(m, 0);
      int k = 0;
      for (int j = 0; j < int((a).size()); ++j) {
        if (a[j] != 0) {
          b[k++] = a[j];
        }
      }
      a = b;
    }
  }
  return 0;
}
