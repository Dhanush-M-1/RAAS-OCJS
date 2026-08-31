#include <bits/stdc++.h>
using namespace std;
string s;
char a[101];
int main() {
  cin >> s;
  for (int i = 0; i < s.size(); i++)
    if (i % 2 == 0) a[i / 2] = s[i];
  sort(a, a + s.size() / 2 + 1);
  cout << a[0];
  for (int i = 1; i <= s.size() / 2; i++) cout << "+" << a[i];
  cout << endl;
  return 0;
}
