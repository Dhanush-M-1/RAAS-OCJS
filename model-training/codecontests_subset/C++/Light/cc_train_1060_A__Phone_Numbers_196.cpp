#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, count = 0;
  cin >> n;
  string cards;
  if (n < 11) {
    cout << "0" << endl;
    return 0;
  } else {
    cin >> cards;
    for (int i = 0; i < n; i++) {
      if (cards[i] == '8') count++;
    }
    int k = n / 11;
    if (count >= k)
      cout << k << endl;
    else
      cout << count << endl;
  }
}
