#include <bits/stdc++.h>
using namespace std;
int k;
void f(int x) {
  string s;
  while (x > 0) {
    char c = '0';
    c += x % k;
    s = c + s;
    x /= k;
  }
  cout << s << " ";
}
int main() {
  cin >> k;
  for (int i = 1; i < k; i++) {
    for (int j = 1; j < k; j++) {
      f(i * j);
    }
    cout << endl;
  }
}
