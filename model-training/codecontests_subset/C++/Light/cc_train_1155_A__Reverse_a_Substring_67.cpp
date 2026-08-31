#include <bits/stdc++.h>
using namespace std;
long long n, r, Min;
char s[300010];
int main() {
  cin >> n;
  scanf("%s", s + 1);
  r = n;
  Min = s[n];
  for (long long l = n - 1; l >= 1; l--) {
    if (s[l] < Min) {
      Min = s[l];
      r = l;
    } else if (s[l] > Min) {
      cout << "YES" << endl << l << ' ' << r << endl;
      return 0;
    }
  }
  cout << "NO" << endl;
  return 0;
}
