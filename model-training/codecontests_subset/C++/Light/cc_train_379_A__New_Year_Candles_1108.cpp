#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b;
  int count = 0;
  cin >> a >> b;
  while (a != 0) {
    count++;
    a--;
    if (count % b == 0) {
      a++;
    }
  }
  cout << count << endl;
}
