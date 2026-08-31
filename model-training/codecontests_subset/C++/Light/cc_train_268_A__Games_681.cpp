#include <bits/stdc++.h>
using namespace std;
struct kk {
  int a;
  int b;
} c[50];
int main() {
  int n, i, k = 0, j;
  cin >> n;
  for (i = 0; i < n; i++) cin >> c[i].a >> c[i].b;
  for (i = 0; i < n; i++)
    for (j = 0; j < n; j++) {
      if (c[i].a == c[j].b) k++;
    }
  cout << k << endl;
}
