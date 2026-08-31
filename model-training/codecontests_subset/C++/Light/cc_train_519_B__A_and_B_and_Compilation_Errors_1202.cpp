#include <bits/stdc++.h>
using namespace std;
int main() {
  int in;
  cin >> in;
  int s;
  long long lsum = 0;
  long long sum = 0;
  int x = 0;
  while (x++ != 3) {
    sum = 0;
    for (int i = 0; i < in; i++) {
      cin >> s;
      sum += s;
    }
    in--;
    if (x == 1) {
      lsum = sum;
      continue;
    }
    cout << lsum - sum << endl;
    lsum = sum;
  }
  return 0;
}
