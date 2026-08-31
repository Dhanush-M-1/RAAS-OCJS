#include <bits/stdc++.h>
using namespace std;
double PI = 3.1415926536;
int main() {
  long long n;
  cin >> n;
  string s;
  cin >> s;
  int a = 0, f = 0, I = 0;
  for (int i = 0; i < n; i++) {
    if (s[i] == 'F')
      f++;
    else if (s[i] == 'I')
      I++;
    else if (s[i] == 'A')
      a++;
  }
  if (a > 0 || f > 0) {
    if (I == 0)
      cout << a;
    else if (I == 1) {
      cout << 1;
    } else {
      cout << 0;
    }
  } else {
    cout << 0;
  }
  return 0;
}
