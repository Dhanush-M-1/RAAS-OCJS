#include <bits/stdc++.h>
using namespace std;
int INF = 100000000;
double EPS = 1e-8;
int main() {
  double a, b, c;
  cin >> a >> b >> c;
  cout << ceil(c * (a - b) / b) << endl;
  return 0;
}
