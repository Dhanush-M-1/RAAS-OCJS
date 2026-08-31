#include <bits/stdc++.h>
using namespace std;
void setup() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cout.precision(15);
}
int main() {
  string a;
  int n, i;
  cin >> a;
  cin >> n;
  for (i = 0; a[i] != '\0'; i++) a[i] = tolower(a[i]);
  for (i = 0; a[i] != '\0'; i++) {
    if (a[i] < n + 97) a[i] += 'A' - 'a';
  }
  cout << a << '\n';
  return 0;
}
