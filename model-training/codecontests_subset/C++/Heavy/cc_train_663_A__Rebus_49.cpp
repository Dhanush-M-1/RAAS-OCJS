#include <bits/stdc++.h>
using namespace std;
const int MAX = 222;
int sign[MAX];
int a[MAX];
int n;
int total;
int getAns() {
  int ans = 0;
  for (int i = 0; i < total; ++i) {
    ans += sign[i] == 1 ? -a[i] : a[i];
  }
  return ans;
}
int toInteger(string str) {
  stringstream ss(str);
  int ret;
  ss >> ret;
  return ret;
}
void show() {
  for (int i = 0; i < total; ++i) {
    if (sign[i] == 0) {
      if (i != 0) cout << " + ";
      cout << a[i];
    } else {
      cout << " - ";
      cout << a[i];
    }
  }
  cout << " = " << getAns() << endl;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  string line;
  getline(cin, line);
  int pos = 0;
  int neg = 0;
  bool negative = false;
  total = 0;
  for (int i = 0; i < ((int)(line).size()); ++i) {
    if (line[i] == '?') {
      if (negative) {
        sign[total++] = 1;
        neg++;
      } else {
        sign[total++] = 0;
        pos++;
      }
      negative = false;
    } else {
      if (line[i] == '-')
        negative = true;
      else if (line[i] == '+')
        negative = false;
    }
  }
  int it = ((int)(line).size()) - 1;
  while (isdigit(line[it])) it--;
  it++;
  n = toInteger(line.substr(it));
  for (int i = 0; i < total; ++i) {
    a[i] = sign[i] == 1 ? n : 1;
  }
  int low = getAns();
  for (int i = 0; i < total; ++i) {
    a[i] = sign[i] == 1 ? 1 : n;
  }
  int high = getAns();
  bool possible = false;
  if (low <= n && high >= n) possible = true;
  if (possible) {
    cout << "Possible" << endl;
    int res = getAns();
    int begin = 0;
    while (res != n) {
      for (int i = begin; i < total; ++i) {
        if (sign[i] == 1 && a[i] < n) {
          a[i]++;
          res--;
          break;
        }
        if (sign[i] == 0 && a[i] > 1) {
          a[i]--;
          res--;
          break;
        }
        begin++;
      }
    }
    show();
  } else {
    cout << "Impossible" << endl;
  }
  return 0;
}
