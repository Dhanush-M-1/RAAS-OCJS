#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  char f;
  int kol = 0;
  long long a[3] = {0};
  while (cin >> f) {
    if (f == 'A') a[0]++;
    if (f == 'I') a[1]++;
    if (f == 'F') a[2]++;
  }
  if (a[1] == 1) cout << 1 << endl;
  if (a[1] > 1) cout << 0;
  if (a[1] == 0) cout << a[0] << endl;
  return 0;
}
