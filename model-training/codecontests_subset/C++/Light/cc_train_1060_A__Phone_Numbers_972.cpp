#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int an = 0;
  char a[100];
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    if (a[i] == '8') {
      an++;
    }
  }
  int m = n / 11;
  cout << min(m, an);
}
