#include <bits/stdc++.h>
using namespace std;
char a[105];
char b[105];
int main() {
  cin >> a;
  int lens = strlen(a);
  int count = 0, t = 0;
  for (int i = 0; i < lens; i++) {
    if (a[i] != '+') {
      b[count++] = a[i];
    }
  }
  sort(b, b + count);
  for (int i = 0; i < count - 1; i++) {
    cout << b[i] << '+';
  }
  cout << b[count - 1] << endl;
  return 0;
}
