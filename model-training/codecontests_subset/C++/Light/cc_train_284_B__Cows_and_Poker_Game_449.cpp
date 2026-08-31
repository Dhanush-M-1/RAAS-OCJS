#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  char s[200100];
  cin >> s;
  int a1 = 0, f1 = 0, i1 = 0, i;
  for (i = 0; s[i] != '\0'; i++) {
    if (s[i] == 'A') a1++;
    if (s[i] == 'F') f1++;
    if (s[i] == 'I') i1++;
  }
  if (i1 > 1) {
    cout << "0"
         << "\n";
  } else {
    if (i1 == 1) {
      cout << "1"
           << "\n";
    } else {
      cout << a1 << "\n";
    }
  }
  cin >> i;
  return 0;
}
