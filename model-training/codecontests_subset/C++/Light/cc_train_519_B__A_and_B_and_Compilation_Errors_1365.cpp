#include <bits/stdc++.h>
using namespace std;
long long a[3];
int main() {
  int n;
  cin >> n;
  int s = 0, s1 = 0, s2 = 0;
  for (int i = 0; i < n; i++) {
    int a;
    cin >> a;
    s += a;
  }
  for (int i = 0; i < n - 1; i++) {
    int a;
    cin >> a;
    s1 += a;
  }
  for (int i = 0; i < n - 2; i++) {
    int a;
    cin >> a;
    s2 += a;
  }
  cout << s - s1 << endl << s1 - s2;
}
