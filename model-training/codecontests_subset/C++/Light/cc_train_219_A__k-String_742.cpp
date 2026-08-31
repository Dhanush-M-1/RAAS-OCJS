#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  string x;
  cin >> x;
  string arr[n];
  sort(x.begin(), x.end());
  for (int i = 0; i < x.length();) {
    for (int b = 0; b < n; b++, i++) {
      if (i < n)
        arr[b] = x[i];
      else
        arr[b] += x[i];
    }
  }
  int c = 0;
  string res = "";
  for (int b = 0; b < n - 1; b++) {
    res += arr[b];
    if (arr[b] != arr[b + 1]) {
      c = 1;
    }
  }
  res += arr[n - 1];
  if (c == 0)
    cout << res;
  else
    cout << -1;
  return 0;
}
