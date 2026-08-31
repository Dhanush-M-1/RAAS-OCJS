#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b;
  cin >> a >> b;
  int went = 0;
  int candles = 0;
  while (a > 0) {
    candles += a;
    went += a;
    a = went / b;
    went = went % b;
  }
  cout << (candles) << endl;
  ;
}
