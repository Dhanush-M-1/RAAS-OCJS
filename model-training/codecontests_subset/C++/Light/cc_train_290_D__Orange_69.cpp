#include <bits/stdc++.h>
using namespace std;
int main() {
  char s[100];
  int n;
  cin >> s >> n;
  for (int i = 0; i < strlen(s); i++) {
    if (s[i] >= 'A' && s[i] <= 'Z') {
      s[i] = s[i] + 32;
    }
    if (s[i] < n + 97) {
      s[i] = s[i] - 32;
    }
  }
  cout << s;
  return 0;
}
