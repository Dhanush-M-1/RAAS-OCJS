#include <bits/stdc++.h>
using namespace std;
long long n, i, c = 0;
struct tree {
  long long p;
  long long h;
};
tree a[100000];
int main() {
  cin >> n;
  for (i = 0; i < n; i++) {
    cin >> a[i].p >> a[i].h;
  }
  if (n > 1)
    c = 2;
  else
    c = 1;
  for (i = 1; i < n - 1; i++) {
    if (a[i].p - a[i].h > a[i - 1].p)
      c++;
    else if (a[i].p + a[i].h < a[i + 1].p) {
      c++;
      a[i].p += a[i].h;
    }
  }
  cout << c;
}
