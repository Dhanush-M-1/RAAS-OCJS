#include <bits/stdc++.h>
using namespace std;
char num[200];
int main() {
  int n, ans = 0;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> num[i];
    if (num[i] == '8') ans++;
  }
  int sum = min(ans, n / 11);
  cout << sum << endl;
}
