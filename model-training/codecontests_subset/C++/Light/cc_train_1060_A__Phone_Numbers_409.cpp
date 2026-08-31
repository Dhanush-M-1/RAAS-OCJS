#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n;
  cin >> n;
  string s;
  cin >> s;
  long long i, a = 0, b = 0;
  for (i = 0; i < n; i++) {
    if (s[i] == '8')
      a++;
    else
      b++;
  }
  long long c = n / 11;
  if (a >= c)
    cout << c;
  else
    cout << a;
}
