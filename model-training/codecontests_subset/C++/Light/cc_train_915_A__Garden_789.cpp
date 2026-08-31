#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k;
  cin >> n >> k;
  int answer = -1;
  int a;
  for (int i = 0; i < n; i++) {
    cin >> a;
    if (k % a == 0 && a > answer) {
      answer = a;
    }
  }
  cout << k / answer;
  return 0;
}
