#include <bits/stdc++.h>
using namespace std;
const int M = 55;
int n, r, a[M], b[M];
void print(int i, int j) {
  cout << "(" << i / 2 << "*((1-abs((t-" << j << ")))+abs((1-abs((t-" << j
       << "))))))";
}
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a[i] >> b[i] >> r;
    if (i) cout << "(";
  }
  for (int i = 0; i < n; i++) {
    if (i) cout << "+";
    print(a[i], i);
    if (i) cout << ")";
  }
  cout << endl;
  for (int i = 1; i < n; i++) cout << "(";
  for (int i = 0; i < n; i++) {
    if (i) cout << "+";
    print(b[i], i);
    if (i) cout << ")";
  }
  cout << endl;
  return 0;
}
