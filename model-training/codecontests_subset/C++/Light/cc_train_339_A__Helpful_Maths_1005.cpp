#include <bits/stdc++.h>
using namespace std;
char a[101];
int b[51];
int main() {
  cin >> a;
  int leng = strlen(a);
  for (int i = 0; i < leng; i += 2) {
    b[i / 2] += a[i] - 48;
  }
  sort(b, b + leng / 2 + 1);
  for (int i = 0; i < leng / 2; ++i) cout << b[i] << "+";
  cout << b[leng / 2];
}
