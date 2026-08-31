#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  int ONE, TWO, THREE;
  cin >> n;
  ONE = 0;
  for (int i = 0; i < n; i++) {
    int c;
    cin >> c;
    ONE = ONE ^ c;
  }
  TWO = 0;
  for (int i = 0; i < n - 1; i++) {
    int c;
    cin >> c;
    TWO = TWO ^ c;
  }
  THREE = 0;
  for (int i = 0; i < n - 2; i++) {
    int c;
    cin >> c;
    THREE = THREE ^ c;
  }
  cout << (ONE ^ TWO) << endl;
  cout << (TWO ^ THREE) << endl;
  return 0;
}
