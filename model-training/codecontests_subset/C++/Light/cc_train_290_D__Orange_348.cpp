#include <bits/stdc++.h>
using namespace std;
int main() {
  char str[100];
  int a;
  cin >> str;
  cin >> a;
  for (int i = 0; i < strlen(str); i++)
    if (str[i] <= 'Z' && str[i] >= 'A') str[i] = str[i] + 32;
  int t = a + 97;
  for (int i = 0; i < strlen(str); i++) {
    if (str[i] < t) {
      str[i] = str[i] - 'a' + 'A';
    }
  }
  cout << str << endl;
  return 0;
}
