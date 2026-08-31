#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  string s1, s2, s3;
  cin >> s;
  int a[3] = {0};
  for (int i = 0; i < s.length(); i += 2) {
    a[s[i] - 49]++;
  }
  int temp = a[0] - 1;
  if (a[1] != 0 || a[2] != 0) temp = a[0];
  for (int i = 0; i < temp; i++) cout << "1+";
  if (temp == a[0] - 1 && a[0] != 0) cout << "1";
  if (a[2] != 0)
    temp = a[1];
  else
    temp = a[1] - 1;
  for (int i = 0; i < temp; i++) cout << "2+";
  if (temp == a[1] - 1 && a[1] != 0) cout << "2";
  for (int i = 0; i < a[2] - 1; i++) cout << "3+";
  if (a[2] != 0) cout << "3";
  return 0;
}
