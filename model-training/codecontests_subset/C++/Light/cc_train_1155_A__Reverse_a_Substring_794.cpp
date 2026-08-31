#include <bits/stdc++.h>
using namespace std;
const int maxx = 3e5 + 100;
string s;
int n;
int main() {
  while (scanf("%d", &n) != EOF) {
    cin >> s;
    int len = s.length();
    int flag = 0;
    int i;
    for (i = 1; i < len; i++) {
      if (s[i] < s[i - 1]) {
        flag = 1;
        break;
      }
    }
    if (flag == 0)
      cout << "NO" << endl;
    else
      cout << "YES" << endl << i << " " << i + 1 << endl;
  }
}
