#include <bits/stdc++.h>
using namespace std;
const int MX = 1e6 + 5;
int n, a, b, x, ar[MX];
string str;
char stt[] = {'a', 'e', 'i', 'o', 'u', 'y'};
bool isvowel(char ch) {
  int k;
  for (k = 0; k < 6; k++)
    if (stt[k] == ch) {
      break;
    }
  if (k == 6) return 0;
  return 1;
}
int main() {
  while (cin >> n) {
    for (int i = 0; i < n; i++) scanf("%d", &ar[i]);
    if (n == 1) {
      printf("%d\n", min(ar[0] - 1, 1000000 - ar[0]));
      continue;
    }
    int ans = 0;
    for (int i = 0; i < n; i++) {
      ans = max(ans, min(ar[i] - 1, 1000000 - ar[i]));
    }
    cout << ans << endl;
  }
  return 0;
}
