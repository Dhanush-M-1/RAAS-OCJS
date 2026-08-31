#include <bits/stdc++.h>
using namespace std;
int k;
int main() {
  cin >> k;
  for (int i = 1; i < k; i++) {
    cout << i;
    for (int j = 2; j < k; j++) {
      if (i * j < k)
        cout << "  " << i * j % k;
      else
        cout << setw(2) << i * j / k << i * j % k;
    }
    cout << endl;
  }
}
