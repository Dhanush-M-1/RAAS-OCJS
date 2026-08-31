#include <bits/stdc++.h>
using namespace std;
int main() {
  int apples;
  int cnt_100 = 0, cnt_200 = 0;
  cin >> apples;
  while (apples--) {
    int weight;
    cin >> weight;
    if (weight == 100)
      cnt_100++;
    else
      cnt_200++;
  }
  if (cnt_100 % 2 == 1) {
    cout << "NO" << endl;
  } else if (cnt_200 % 2 == 0) {
    cout << "YES" << endl;
  } else if (cnt_100 / 2 > 0) {
    cout << "YES" << endl;
  } else {
    cout << "NO" << endl;
  }
  return 0;
}
