#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b;
  cin >> a >> b;
  int result = a;
  int temp = 0;
  while ((a + temp) >= b) {
    int t1 = temp;
    result += (a + temp) / b;
    temp = (a + temp) % b;
    a = (a + t1) / b;
  }
  cout << result << endl;
  return 0;
}
