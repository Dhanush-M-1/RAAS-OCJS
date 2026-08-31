#include <bits/stdc++.h>
using namespace std;
void printbase(int n, int k) {
  stack<int> temp;
  while (n) {
    temp.push(n % k);
    n /= k;
  }
  while (!temp.empty()) {
    cout << temp.top();
    temp.pop();
  }
  return;
}
int main() {
  int k;
  cin >> k;
  for (int i = 1; i < k; i++) {
    for (int j = 1; j < k; j++) {
      printbase(i * j, k);
      cout << ' ';
    }
    cout << '\n';
  }
  return 0;
}
