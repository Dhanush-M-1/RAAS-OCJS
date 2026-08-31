#include <bits/stdc++.h>
using namespace std;
string ini, iniS;
int n;
int main() {
  cin >> n >> ini;
  iniS = ini;
  sort(iniS.begin(), iniS.end());
  for (int i = 0; i < n; i++) {
    if (iniS[i] < ini[i]) {
      for (int j = i + 1; j < n; j++) {
        if (iniS[i] == ini[j]) {
          printf("YES\n%d %d", i + 1, j + 1);
          return 0;
        }
      }
    }
  }
  printf("No");
  return 0;
}
