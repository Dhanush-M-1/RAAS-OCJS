#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, count = 0;
  cin >> n;
  for (int i = 0; i < n; i++) {
    char ch;
    cin >> ch;
    if (ch == '8') count++;
  }
  if (count == 0)
    cout << 0;
  else
    cout << (count >= n / 11 ? n / 11 : count);
}
