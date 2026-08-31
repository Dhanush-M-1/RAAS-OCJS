#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, num = 0, i;
  vector<int> v;
  string s1;
  cin >> s1;
  int l = s1.size();
  for (int i = 0; i < l; i++) {
    char c = s1[i];
    if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' ||
        c == '6' || c == '7' || c == '8' || c == '9') {
      n = c - '0';
      num = (num * 10) + n;
    }
    if (c == '+') {
      v.push_back(num);
      num = 0;
    }
  }
  v.push_back(num);
  int a = v.size();
  int m = a - 1;
  for (int i = 0; i < m; i++) {
    if (v[i] > v[i + 1]) {
      int f = v[i + 1];
      v[i + 1] = v[i];
      v[i] = f;
    }
    if (i == m - 1) {
      i = -1;
      m--;
    }
  }
  for (int i = 0; i < a; i++)
    if (i == 0)
      cout << v[i];
    else
      cout << "+" << v[i];
}
