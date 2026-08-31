#include <bits/stdc++.h>
using namespace std;
int main() {
  int num, div, rem;
  cin >> num >> div;
  int cnt = num;
  while (num >= div) {
    rem = num % div;
    num = num / div;
    cnt = cnt + num;
    num = num + rem;
  }
  cout << cnt << endl;
  return 0;
}
