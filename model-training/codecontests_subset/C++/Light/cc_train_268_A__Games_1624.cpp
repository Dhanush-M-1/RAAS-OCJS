#include <bits/stdc++.h>
using namespace std;
int a[101], b[101];
int main() {
  int n, l = 0;
  cin >> n;
  int a1, b1;
  for (int i = 0; i < n; i++) {
    cin >> a[i] >> b[i];
  }
  for (int i = 0; i < 101; i++) {
    for (int y = 0; y < 101; y++) {
      if (a[i] == b[y] && a[i] != 0) l++;
    }
  }
  cout << l;
}
