#include <bits/stdc++.h>
using namespace std;
int main() {
  string a;
  cin >> a;
  for (int j = 2; j < a.length(); ++j) {
    if (a[j] == '+') continue;
    int key = int(a[j]);
    int i = j - 2;
    while (i >= 0 && int(a[i]) > key) {
      a[i + 2] = a[i];
      i -= 2;
    }
    a[i + 2] = key;
  }
  cout << a;
}
