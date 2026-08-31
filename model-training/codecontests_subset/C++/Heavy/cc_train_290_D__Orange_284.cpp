#include <bits/stdc++.h>
using namespace std;
const int vx[] = {1, 0, -1, 0}, vy[] = {0, 1, 0, -1};
const double EPS = 1e-9;
const int days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
const int daysleap[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
int main() {
  string str;
  int a;
  cin >> str >> a;
  for (int i = 0; i < str.size(); i++) {
    if (str[i] >= 'A' && str[i] <= 'Z') str[i] = str[i] - 'A' + 'a';
  }
  for (int i = 0; i < str.size(); i++) {
    if (str[i] < 97 + a && str[i] >= 'a' && str[i] <= 'z')
      str[i] = str[i] - 'a' + 'A';
    else if (str[i] >= 97 + a && str[i] >= 'A' && str[i] <= 'Z')
      str[i] = str[i] - 'A' + 'a';
  }
  cout << str << endl;
  return 0;
}
