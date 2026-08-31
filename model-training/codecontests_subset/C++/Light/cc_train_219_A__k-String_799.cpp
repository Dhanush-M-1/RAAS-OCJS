#include <bits/stdc++.h>
using namespace std;
int Farr[26], k;
char arr[1005];
string ans;
int main() {
  scanf("%d %s", &k, arr);
  for (int i = 0; arr[i] != '\0'; i++) {
    Farr[arr[i] - 'a']++;
  }
  for (int i = 0; i < 26; i++) {
    if (Farr[i] % k != 0) {
      printf("-1");
      return 0;
    } else
      for (int j = 0; j < Farr[i] / k; j++) {
        ans += static_cast<char>('a' + i);
      }
  }
  while (k--) cout << ans;
  return 0;
}
