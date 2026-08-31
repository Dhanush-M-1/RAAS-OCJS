#include <bits/stdc++.h>
using namespace std;
int main() {
  int a1 = 0;
  int a2 = 0;
  int a3 = 0;
  string s;
  cin >> s;
  for (int i = 0; i < s.length(); i += 2) {
    if (s[i] - 48 == 1) a1 += 1;
    if (s[i] - 48 == 2) a2 += 1;
    if (s[i] - 48 == 3) a3 += 1;
  }
  if (a1 != 0) {
    cout << 1;
    a1--;
  } else if (a2 != 0) {
    a2--;
    cout << 2;
  } else {
    a3--;
    cout << 3;
  }
  for (int i = 0; i < a1; i++) cout << '+' << 1;
  for (int i = 0; i < a2; i++) cout << '+' << 2;
  for (int i = 0; i < a3; i++) cout << '+' << 3;
}
