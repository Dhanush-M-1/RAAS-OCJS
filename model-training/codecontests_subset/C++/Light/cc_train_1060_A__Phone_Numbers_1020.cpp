#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, count = 0;
  char st[100];
  cin >> n;
  cin >> st;
  if (n >= 11) {
    for (int i = 0; i <= n; i++) {
      if (st[i] == '8')
        count++;
      else
        continue;
    }
    if (count == 0) {
      count = 0;
    } else if (count != 0 && n / count >= 11) {
      count = count;
    } else {
      count = n / 11;
    }
  }
  cout << count;
}
