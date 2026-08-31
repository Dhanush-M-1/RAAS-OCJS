#include <bits/stdc++.h>
using namespace std;
void print(vector<int> numbers) {
  for (auto it : numbers) {
    cout << it << " ";
  }
}
int main() {
  int t;
  cin >> t;
  while (t--) {
    int a, b, c;
    cin >> a >> b >> c;
    int firstVar = 0;
    int secondVar = 0;
    int a1 = a;
    int b1 = b;
    while (true) {
      if (a1 <= 0 || b1 <= 1) {
        break;
      }
      firstVar += 3;
      a1 = a1 - 1;
      b1 = b1 - 2;
    }
    int c1 = c;
    while (true) {
      if (c1 <= 1 || b1 <= 0) {
        break;
      }
      firstVar += 3;
      c1 = c1 - 2;
      b1 = b1 - 1;
    }
    int b2 = b;
    int c2 = c;
    while (true) {
      if (b2 <= 0 || c2 <= 1) {
        break;
      }
      secondVar += 3;
      c2 = c2 - 2;
      b2 = b2 - 1;
    }
    int a2 = a;
    while (true) {
      if (b2 <= 1 || a2 <= 0) {
        break;
      }
      secondVar += 3;
      a2 = a2 - 1;
      b2 = b2 - 2;
    }
    cout << max(firstVar, secondVar) << "\n";
  }
}
