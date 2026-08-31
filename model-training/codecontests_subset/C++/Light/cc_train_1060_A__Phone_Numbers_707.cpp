#include <bits/stdc++.h>
using namespace std;
long long int arr[10];
int main() {
  long long int n, i, res = 0, eight = 0, sum = 0;
  cin >> n;
  char str[n];
  scanf(" %s", str);
  for (i = 0; i < n; i++) {
    arr[str[i] - '0']++;
    if (str[i] - '0' == 8) {
      ++eight;
    }
  }
  long long int devide = n / 11;
  if (eight >= devide)
    res = devide;
  else
    res = eight;
  cout << res << endl;
  return 0;
}
