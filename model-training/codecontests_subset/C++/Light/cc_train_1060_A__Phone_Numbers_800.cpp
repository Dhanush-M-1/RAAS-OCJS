#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int cnt = 0;
  for (int i = 1; i <= n; i++) {
    char ch;
    cin >> ch;
    if (ch == '8') cnt++;
  }
  cout << min(n / 11, cnt);
}
