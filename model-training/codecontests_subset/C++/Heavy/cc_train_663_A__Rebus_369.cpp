#include <bits/stdc++.h>
using namespace std;
int main(void) {
  char a;
  int k = 0;
  vector<int> s;
  while (1) {
    cin >> a >> a;
    k++;
    if (a == '+')
      s.push_back(1);
    else if (a == '-')
      s.push_back(-1);
    else
      break;
  }
  int n;
  cin >> n;
  int plus = 0, minus = 0;
  for (int i = 0; i < k - 1; i++) {
    if (s[i] == 1)
      plus++;
    else
      minus++;
  }
  if (minus > n * plus || plus + 1 > n * (minus + 1)) {
    cout << "Impossible" << endl;
    return 0;
  }
  if (plus + 1 > n + minus) {
    cout << "Possible" << endl;
    int x = n + n * minus - plus - 1;
    if (x > n - 1) {
      cout << n;
      x -= (n - 1);
    } else {
      cout << x + 1;
      x = 0;
    }
    for (int i = 0; i < k - 1; i++) {
      if (s[i] == 1) {
        cout << " + ";
        if (x > n - 1) {
          cout << n;
          x -= (n - 1);
        } else {
          cout << x + 1;
          x = 0;
        }
      } else {
        cout << " - " << n;
      }
    }
    cout << " = " << n << endl;
    return 0;
  }
  cout << "Possible" << endl;
  int x = n + minus - plus - 1;
  if (x > n - 1) {
    cout << n;
    x -= (n - 1);
  } else {
    cout << x + 1;
    x = 0;
  }
  for (int i = 0; i < k - 1; i++) {
    if (s[i] == 1) {
      cout << " + ";
      if (x > n - 1) {
        cout << n;
        x -= (n - 1);
      } else {
        cout << x + 1;
        x = 0;
      }
    } else {
      cout << " - 1";
    }
  }
  cout << " = " << n << endl;
  return 0;
}
