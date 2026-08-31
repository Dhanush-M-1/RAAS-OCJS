#include <bits/stdc++.h>
using namespace std;
int n, i, cate, cate2;
char s;
int main() {
  cin >> n;
  for (i = 1; i <= n; i++) {
    cin >> s;
    if (s == '8') cate2++;
  }
  cout << min(n / 11, cate2);
  return 0;
}
