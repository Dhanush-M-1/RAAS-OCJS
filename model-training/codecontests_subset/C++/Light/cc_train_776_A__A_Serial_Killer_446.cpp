#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n;
  char s[15], s1[15], l[15], k[15];
  cin >> s >> s1;
  cin >> n;
  cout << s << " " << s1 << endl;
  while (n--) {
    cin >> k >> l;
    if (strcmp(k, s) == 0) {
      cout << l << " " << s1 << endl;
      strcpy(s, l);
    } else if (strcmp(k, s1) == 0) {
      cout << l << " " << s << endl;
      strcpy(s1, l);
    }
  }
  return 0;
}
