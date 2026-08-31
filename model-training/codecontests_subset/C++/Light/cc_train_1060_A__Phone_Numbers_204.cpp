#include <bits/stdc++.h>
using namespace std;
int n, temp = 0, num = 0;
char x[105];
int main() {
  cin >> n;
  scanf("%s", &x);
  for (int i = 0; i < n; i++) {
    if (x[i] == '8') temp++;
  }
  num = min(n / 11, temp);
  cout << num;
  return 0;
}
