#include <bits/stdc++.h>
using namespace std;
int main() {
  double n, x, y;
  cin >> n >> x >> y;
  if ((x / n) * 100 >= y) {
    cout << "0";
  } else {
    double temp = ceil((n * y) / 100);
    int answer = abs(x - temp);
    cout << answer;
  }
  return 0;
}
