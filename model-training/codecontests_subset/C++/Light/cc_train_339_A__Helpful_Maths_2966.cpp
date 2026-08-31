#include <bits/stdc++.h>
using namespace std;
int main() {
  char s[100];
  cin >> s;
  int i = 0, ind;
  while (s[i]) i++;
  for (int k = 0; k <= i; k += 2) {
    ind = k;
    for (int j = k + 2; j <= i; j += 2) {
      if (s[j] < s[ind]) {
        ind = j;
      }
    }
    swap(s[k], s[ind]);
  }
  cout << s << endl;
}
