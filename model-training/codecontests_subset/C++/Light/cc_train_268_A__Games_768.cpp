#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c = 0;
  cin >> n;
  int a[n * 2];
  for (int i = 0; i < n * 2; i++) cin >> a[i];
  if (n == 2) {
    if (a[1] == a[2]) c++;
    if (a[0] == a[3]) c++;
  } else {
    for (int i = 1; i < n * 2; i += 2) {
      for (int j = 0; j < n * 2; j += 2) {
        if (a[i] == a[j]) c++;
      }
      if (a[i] == a[i - 1]) c--;
    }
  }
  cout << c;
  return 0;
}
