#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, check = 0;
  cin >> n;
  char a[n];
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    if (a[i] == '8') check++;
  }
  int k = n / 11;
  if (k < check)
    cout << k;
  else
    cout << check;
}
