#include <bits/stdc++.h>
using namespace std;
long long a, b, maks, counter, total_1, total_2, total_3;
int main() {
  cin >> a;
  for (int i = 0; i < a; i++) {
    cin >> b;
    total_1 = total_1 + b;
  }
  for (int i = 0; i < a - 1; i++) {
    cin >> b;
    total_2 = total_2 + b;
  }
  for (int i = 0; i < a - 2; i++) {
    cin >> b;
    total_3 = total_3 + b;
  }
  cout << total_1 - total_2 << endl;
  cout << total_2 - total_3;
}
