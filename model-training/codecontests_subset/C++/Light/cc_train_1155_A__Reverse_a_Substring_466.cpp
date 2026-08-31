#include <bits/stdc++.h>
using namespace std;
char s[1000100];
int num[27];
int main() {
  int n;
  cin >> n;
  scanf("%s", s + 1);
  int len = strlen(s + 1);
  for (int i = len; i >= 1; i--) {
    num[s[i] - 'a'] = i;
    for (int j = s[i] - 'a' - 1; j >= 0; j--) {
      if (num[j]) {
        cout << "YES\n";
        cout << i << " " << num[j] << endl;
        return 0;
      }
    }
  }
  cout << "NO\n";
  return 0;
}
