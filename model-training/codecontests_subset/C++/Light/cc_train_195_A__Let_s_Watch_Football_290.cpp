#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c;
  cin >> a >> b >> c;
  int data_req = a * c;
  int time = data_req / b;
  time = time - c;
  if (data_req % b == 0) {
    cout << time;
  } else {
    cout << time + 1 << endl;
  }
  return 0;
}
