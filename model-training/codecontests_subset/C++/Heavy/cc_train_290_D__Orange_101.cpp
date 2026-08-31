#include <bits/stdc++.h>
using namespace std;
char ma[100][100] = {
    "Washington", "Adams",     "Jefferson", "Madison",    "Monroe",
    "Adams",      "Jackson",   "Van Buren", "Harrison",   "Tyler",
    "Polk",       "Taylor",    "Fillmore",  "Pierce",     "Buchanan",
    "Lincoln",    "Johnson",   "Grant",     "Hayes",      "Garfield",
    "Arthur",     "Cleveland", "Harrison",  "Cleveland",  "McKinley",
    "Roosevelt",  "Taft",      "Wilson",    "Harding",    "Coolidge",
    "Hoover",     "Roosevelt", "Truman",    "Eisenhower", "Kennedy",
    "Johnson",    "Nixon",     "Ford",      "Carter",     "Reagan",
    "Bush",       "Clinton"};
char s[100];
int main(int argc, char* argv[]) {
  std::ios::sync_with_stdio(false);
  int a;
  cin >> s;
  cin >> a;
  for (int i = 0; i < strlen(s); i++) {
    if (s[i] <= 90) s[i] = s[i] - 'A' + 'a';
    if (s[i] < a + 97) s[i] = s[i] - 'a' + 'A';
  }
  cout << s << endl;
  return 0;
}
