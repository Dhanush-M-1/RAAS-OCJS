#include <bits/stdc++.h>
using namespace std;
char str[300005];
int main() {
  int n;
  while (~scanf("%d", &n)) {
    scanf("%s", str + 1);
    int temp = (int)str[1];
    int pos = -1;
    for (int i = 2; i <= n; i++) {
      int x = (int)str[i];
      if (x < temp) {
        pos = i;
        break;
      }
      temp = x;
    }
    if (pos == -1)
      cout << "NO" << endl;
    else {
      cout << "YES" << endl;
      cout << pos - 1 << " " << pos << endl;
    }
  }
}
