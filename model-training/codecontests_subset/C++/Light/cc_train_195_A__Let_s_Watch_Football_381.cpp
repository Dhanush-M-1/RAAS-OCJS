#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c;
  cin >> a >> b >> c;
  int zhdan = 0;
  while (true) {
    if ((zhdan + c) * b >= a * c) {
      cout << zhdan << endl;
      return 0;
    }
    zhdan++;
  }
}
