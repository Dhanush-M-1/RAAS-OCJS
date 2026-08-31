#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int a, i, j = 0, s = 0;
  cin >> a;
  long long int b[a], c[a];
  for (i = 0; i < a; i++) {
    cin >> b[i] >> c[j];
    j++;
  }
  for (i = 0; i < a; i++) {
    for (j = 0; j < a; j++) {
      if (b[i] == c[j]) {
        s++;
      }
    }
  }
  cout << s;
}
