#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a = 0, i;
  cin >> n;
  char ch[n + 5];
  for (i = 0; i < n; i++) {
    cin >> ch[i];
    if (ch[i] == '8') a++;
  }
  cout << min(a, n / 11) << endl;
  return 0;
}
