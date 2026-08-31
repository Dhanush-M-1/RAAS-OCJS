#include <bits/stdc++.h>
using namespace std;
char map[1005][1005];
char a[1004];
int n;
int main() {
  cin >> a;
  cin >> n;
  for (int i = 0; i < strlen(a); i++) {
    if (a[i] >= 'A' && a[i] <= 'Z') a[i] += 'a' - 'A';
  }
  for (int i = 0; i < strlen(a); i++) {
    if (a[i] < n + 97) a[i] -= 'a' - 'A';
  }
  cout << a << endl;
  return 0;
}
