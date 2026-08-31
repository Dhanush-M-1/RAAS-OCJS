#include <bits/stdc++.h>
using namespace std;
int strToInt(string str) {
  int ans;
  stringstream s;
  s << str;
  s >> ans;
  return ans;
}
string intToStr(int n) {
  string str;
  stringstream s;
  s << n;
  s >> str;
  return str;
}
int MAX(int a, int b) {
  if (a > b) return a;
  return b;
}
int MIN(int a, int b) {
  if (a < b) return a;
  return b;
}
int ABS(int a, int b) {
  if (a > 0) return a;
  return -a;
}
int main() {
  string str;
  cin >> str;
  int number, len, temp;
  cin >> number;
  len = str.size();
  for (int i = 0; i < len; i++) {
    if (str[i] >= 'a')
      temp = str[i] - 'a';
    else
      temp = str[i] - 'A';
    if (temp < number) {
      str[i] = char('A' + temp);
    } else
      str[i] = char('a' + temp);
  }
  cout << str;
  return 0;
}
