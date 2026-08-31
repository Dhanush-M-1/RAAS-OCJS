#include <bits/stdc++.h>
using namespace std;
long long to_int(string s) {
  long long ans = 0;
  long long x = 1;
  for (int i = 29; i >= 0; i--) {
    if (s[i] == '1') ans += x;
    x *= 2;
  }
  return ans;
}
void read_input(int &x) {
  int t;
  cin >> t;
  x = t;
}
int main() {
  cout.flush();
  string a = string(30, '0');
  string b = string(30, '0');
  cout << "? 0 0" << endl;
  int sign;
  read_input(sign);
  for (int i = 0; i < 30; i++) {
    int temp1, temp2;
    if (sign == 1) {
      a[i] = '1';
      b[i] = '1';
      cout << "? " << to_int(a) << " " << to_int(b) << endl;
      read_input(temp1);
      a[i] = '0';
      b[i] = '1';
      cout << "? " << to_int(a) << " " << to_int(b) << endl;
      read_input(temp2);
      if (temp1 == -1) {
        a[i] = '1';
        b[i] = '0';
        sign = temp2;
      } else if (temp2 == -1) {
        a[i] = '0';
        b[i] = '0';
      } else {
        a[i] = '1';
        b[i] = '1';
      }
    } else if (sign == -1) {
      a[i] = '1';
      b[i] = '1';
      cout << "? " << to_int(a) << " " << to_int(b) << endl;
      read_input(temp1);
      a[i] = '0';
      b[i] = '1';
      cout << "? " << to_int(a) << " " << to_int(b) << endl;
      read_input(temp2);
      if (temp1 == 1) {
        a[i] = '0';
        b[i] = '1';
        sign = temp2;
      } else if (temp2 == -1) {
        a[i] = '0';
        b[i] = '0';
      } else {
        a[i] = '1';
        b[i] = '1';
      }
    } else {
      a[i] = '1';
      b[i] = '0';
      cout << "? " << to_int(a) << " " << to_int(b) << endl;
      read_input(temp1);
      if (temp1 > 0) {
        a[i] = '0';
        b[i] = '0';
      } else {
        a[i] = '1';
        b[i] = '1';
      }
    }
  }
  cout << "! " << to_int(a) << " " << to_int(b) << endl;
}
