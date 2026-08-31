#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  string s;
  cin >> n;
  cin >> s;
  int count = 0;
  for (int i = 0; i < n; i++) {
    if (s[i] == '8') {
      count++;
    }
  }
  int a = n / 11;
  if (count >= a) {
    cout << a;
  } else {
    cout << count;
  }
  return 0;
}
