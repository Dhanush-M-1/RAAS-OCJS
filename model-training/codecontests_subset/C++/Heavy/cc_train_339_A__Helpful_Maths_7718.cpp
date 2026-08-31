#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  long long int n1 = 0, n2 = 0, n3 = 0;
  long long int m1 = 0, m2 = 0, m3 = 0;
  cin >> s;
  for (long long int i = 0; i < s.size(); i++) {
    if (s[i] == '1') n1 += 1;
    if (s[i] == '2') n2 += 1;
    if (s[i] == '3') n3 += 1;
  }
  m1 = n1;
  m2 = n2;
  m3 = n3;
  if (m1 > 0) {
    cout << "1";
    n1--;
  }
  while (n1--) {
    cout << "+1";
  }
  if (m2 > 0 && m1 == 0) {
    cout << "2";
    n2--;
  }
  if (m2 > 0 && m1 > 0) {
    cout << "+2";
    n2--;
  }
  while (n2--) {
    cout << "+2";
  }
  if (m3 > 0 && (m2 == 0 && m1 == 0)) {
    cout << "3";
    n3--;
  }
  if (m3 > 0 && (m2 > 0 || m1 > 0)) {
    cout << "+3";
    n3--;
  }
  while (n3--) {
    cout << "+3";
  }
  return 0;
}
