#include <bits/stdc++.h>
using namespace std;
int main(int argc, char const *argv[]) {
  int m, n;
  int a[3];
  cin >> n;
  for (int i = 0; i < 3; i++) {
    a[i] = 0;
    for (int j = 0; j < n - i; j++) {
      cin >> m;
      a[i] = a[i] + m;
    }
  }
  cout << a[0] - a[1] << endl;
  cout << a[1] - a[2] << endl;
  return 0;
}
