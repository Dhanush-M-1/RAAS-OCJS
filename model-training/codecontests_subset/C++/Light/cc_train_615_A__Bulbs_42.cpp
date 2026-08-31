#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  cin >> n >> m;
  bool arr[101] = {false};
  int bulbsNumber, counter = 0;
  for (int i = 0; i < n; i++) {
    cin >> bulbsNumber;
    for (int j = 0; j < bulbsNumber; j++) {
      int bulb;
      cin >> bulb;
      if (!arr[bulb]) {
        counter++;
        arr[bulb] = true;
      }
      if (counter == m) {
        cout << "YES";
        return 0;
      }
    }
  }
  cout << "NO";
  return 0;
}
