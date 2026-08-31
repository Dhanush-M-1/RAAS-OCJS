#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, hom[31], guest[31], count = 0;
  cin >> a;
  for (int i = 0; i < a; i++) {
    cin >> hom[i] >> guest[i];
  }
  for (int i = 0; i < a; i++) {
    for (int j = 0; j < a; j++) {
      if (hom[i] == guest[j]) {
        count++;
      }
    }
  }
  cout << count;
  return 0;
}
