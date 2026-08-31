#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  string s;
  cin >> s;
  int a = count(s.begin(), s.end(), 'A');
  int i = count(s.begin(), s.end(), 'I');
  int f = count(s.begin(), s.end(), 'F');
  if (i > 1)
    cout << 0;
  else if (i == 1)
    cout << 1;
  else
    cout << a;
  return 0;
}
