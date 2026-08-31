#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int a[100];
  for (int i = 0; i < 2 * n; i++) {
    cin >> a[i];
  }
  int count = 0;
  int x;
  for (int i = 0; i < 2 * n; i += 2) {
    x = i + 3;
    for (x; x < 2 * n; x += 2) {
      if (a[i] == a[x]) count++;
    }
  }
  int y;
  for (int i = 1; i < 2 * n; i += 2) {
    y = i + 1;
    for (y; y < 2 * n; y += 2) {
      if (a[i] == a[y]) count++;
    }
  }
  cout << count << endl;
  return 0;
}
