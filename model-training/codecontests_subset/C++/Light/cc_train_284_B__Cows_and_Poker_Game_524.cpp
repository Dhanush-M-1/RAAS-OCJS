#include <bits/stdc++.h>
using namespace std;
int n;
int a[1000];
int main() {
  cin >> n;
  for (int i = 0; i < int(n); ++i) {
    char c;
    cin >> c;
    a[c]++;
  }
  if (a['I'] > 1) {
    cout << 0;
  } else if (a['I'] == 1) {
    cout << 1;
  } else {
    cout << a['A'];
  }
  return 0;
}
