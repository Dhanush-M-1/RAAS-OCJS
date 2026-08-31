#include <bits/stdc++.h>
using namespace std;
int main(int argc, char** argv) {
  int a = 0, b = 0;
  cin >> a >> b;
  int count = 0;
  count += a;
  while (a >= b) {
    int temp = a / b;
    int rim = a % b;
    count += temp;
    a = temp + rim;
  }
  cout << count << endl;
  return 0;
}
