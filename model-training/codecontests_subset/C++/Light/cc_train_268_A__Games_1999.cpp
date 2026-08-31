#include <bits/stdc++.h>
using namespace std;
long long a, b[1000000], c[1000000], d, e;
int main() {
  cin >> a;
  for (int i = 0; i < a; i++) {
    cin >> b[i] >> c[i];
  }
  for (int i = 0; i < a; i++) {
    for (int j = 0; j < a; j++) {
      if (i != j && b[i] == c[j]) {
        d++;
      }
    }
  }
  cout << d;
}
