#include <bits/stdc++.h>
using namespace std;
int main() {
  char s[110], c;
  int i, j;
  cin >> s;
  for (i = 0; i < strlen(s); i += 2) {
    for (j = i + 2; j < strlen(s); j += 2) {
      if (s[i] > s[j]) {
        c = s[i];
        s[i] = s[j];
        s[j] = c;
      }
    }
  }
  cout << s << endl;
}
