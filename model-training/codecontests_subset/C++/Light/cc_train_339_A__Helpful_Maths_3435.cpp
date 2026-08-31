#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, j, k;
  char s[200];
  cin >> s;
  int A[4];
  for (i = 0; i < 4; i++) A[i] = 0;
  k = 0;
  for (i = 0; s[i] != '\0'; i++) {
    if (s[i] == '+') {
      A[k]++;
      k = 0;
    } else
      k = s[i] - '0';
  }
  A[k]++;
  j = 0;
  for (i = 1; i <= 3; i++) {
    while (A[i] > 0) {
      s[j++] = i + '0';
      s[j++] = '+';
      A[i]--;
    }
  }
  s[j - 1] = '\0';
  cout << s;
  return 0;
}
