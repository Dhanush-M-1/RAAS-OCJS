#include <bits/stdc++.h>
using namespace std;
int a, b, c;
int n;
int main() {
  cin >> n;
  int t;
  for (int i = 0; i < (int)n; i++) {
    scanf("%ld", &t);
    a += t;
  }
  for (int i = 0; i < (int)n - 1; i++) {
    scanf("%ld", &t);
    b += t;
  }
  cout << a - b << endl;
  for (int i = 0; i < (int)n - 2; i++) {
    scanf("%ld", &t);
    c += t;
  }
  cout << b - c;
  return 0;
}
