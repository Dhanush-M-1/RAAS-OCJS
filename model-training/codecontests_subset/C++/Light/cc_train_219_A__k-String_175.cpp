#include <bits/stdc++.h>
using namespace std;
int main() {
  int k;
  string x;
  cin >> k >> x;
  sort(x.begin(), x.end());
  int a[26];
  for (int i = 0; i < 26; i++) a[i] = 0;
  for (int i = 0; i < x.length(); i++) a[x[i] - 97]++;
  for (int i = 0; i < 26; i++) {
    if (a[i] % k != 0) {
      cout << -1;
      return 0;
    }
  }
  for (int i = 0; i < k; i++)
    for (int j = 0; j < 26; j++)
      for (int c = 0; c < a[j] / k; c++) cout << (char)(j + 97);
  return 0;
}
