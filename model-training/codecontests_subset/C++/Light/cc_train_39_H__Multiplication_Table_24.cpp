#include <bits/stdc++.h>
using namespace std;
int main() {
  int k;
  cin >> k;
  for (int i = 1; i < k; i++) {
    for (int j = 1; j < k; j++) cout << ((i * j) / k) * 10 + (i * j) % k << " ";
    cout << endl;
  }
  return 0;
}
