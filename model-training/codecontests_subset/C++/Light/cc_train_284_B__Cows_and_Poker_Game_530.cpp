#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  string s;
  cin >> s;
  int a = count(s.begin(), s.end(), 'A');
  int i = count(s.begin(), s.end(), 'I');
  if (i == 0) {
    cout << a;
  } else if (i == 1) {
    cout << 1;
  } else {
    cout << 0;
  }
}
