#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  for (int i = 1; i < n; i++) {
    for (int j = 1; j < n; j++) {
      int x = (i * j / n) * 10 + (i * j % n);
      cout << x << " ";
    }
    cout << endl;
  }
}
